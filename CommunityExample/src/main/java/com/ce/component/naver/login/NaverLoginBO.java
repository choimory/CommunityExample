package com.ce.component.naver.login;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class NaverLoginBO {
	private static final String CLIENT_ID="6nL8FlQEop_opQY_rIZA"; //애플리케이션 등록할때 네이버가 준 id
	private static final String CLIENT_SECRET="_oMZOWmlaU"; //애플리케이션 등록할때 네이버가 준 secret
	private final static String CALLBACK_REDIRECT_URI = "http://localhost:8080/communityexample/callback"; // 네이버가 받은 요청 완료하고 갈 주소
	private final static String SESSION_STATE_KEY = "oauth_state"; // 보안용으로 설정해둘 세션의 key
	private final static String SESSION_STATE_VALUE = "any_code"; // 보안용으로 설정해둘 세션의 value
	private final static String PROFILE_API_URL="https://openapi.naver.com/v1/nid/me"; // 네이버가 콜백하면서 보낸 프로필데이터를 조회하는 api
	
	//요청보내기 - 네이버에 인증 요청보낼 URL 만들기
	public String getAuthorizationUrl(HttpSession session) {
		String authUrl=null;
		OAuth20Service oauth20=null; 
		
		session.setAttribute(SESSION_STATE_KEY, SESSION_STATE_VALUE); //서버에서 세션을 임의로 만들어서 저장(보안, 확인용)
		
		oauth20=new ServiceBuilder()
				.apiKey(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(CALLBACK_REDIRECT_URI)
				.state(SESSION_STATE_VALUE) // 보안용으로 만든 세션의 value도 같이 보냄
				.build(NaverLoginApi.getNaverLoginApiInstance());
		
		authUrl=oauth20.getAuthorizationUrl();		
		return authUrl;
	}
	
	// 요청받기 - 네이버에서 인증 완료하고 보내는 토큰
	public OAuth2AccessToken getAccessToken(HttpSession session, String state, String code) { // session, state, code은 네이버측에서 콜백하면서 컨트롤러에 건내주나봄
		OAuth20Service oauth20=null; 
		OAuth2AccessToken token=null;
		String sessionStateValue=null;
		
		sessionStateValue=(String)session.getAttribute(SESSION_STATE_KEY);  //콜백에서 준 세션에서 값을 꺼냄
		
		if(sessionStateValue.equals(SESSION_STATE_VALUE)) { // 위에서 꺼낸값을 내가 보안용으로 만든 세션값과 일치하는지 확인
			oauth20=new ServiceBuilder()
					.apiKey(CLIENT_ID)
					.apiSecret(CLIENT_SECRET)
					.callback(CALLBACK_REDIRECT_URI)
					.state(SESSION_STATE_VALUE)
					.build(NaverLoginApi.getNaverLoginApiInstance());			
			try {
				token=oauth20.getAccessToken(code);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
		
		return token;
	}
	
	// 조회하기 - 네이버가 콜백하면서 보낸 프로필데이터를 api로 조회하기
	public String getUserProfile(OAuth2AccessToken token) {
		String userProfile=null;
		OAuth20Service oauth20=null;
		OAuthRequest oauthReq=null;
		Response res=null;
		
		oauth20=new ServiceBuilder()
				.apiKey(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(CALLBACK_REDIRECT_URI)
				.build(NaverLoginApi.getNaverLoginApiInstance());
		
		oauthReq=new OAuthRequest(Verb.GET, PROFILE_API_URL, oauth20);
		oauth20.signRequest(token, oauthReq);				
		
		res=oauthReq.send();		
		try {
			userProfile=res.getBody();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return userProfile;
	}
}
