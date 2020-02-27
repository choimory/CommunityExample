package com.ce.component.naver.login;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginApi extends DefaultApi20 { //scribejava = OAuth관련 라이브러리, DefaultApi20 = OAuth2.0 //이후 OAuth2.0객체 생성할때 이 클래스의 인스턴스를 사용
	
	//1.생성자 제한걸어서 객체생성 제한
	protected NaverLoginApi(){		
	}
	
	//2.내부클래스에서 객체 참조변수생성
	private static class InstanceHolder{
		private static final NaverLoginApi NAVER_LOGIN_API_INSTANCE=new NaverLoginApi();
	}
	
	//3.public static getter로 생성된 객체지급(1+2+3=싱글턴)
	public static NaverLoginApi getNaverLoginApiInstance() {
		return InstanceHolder.NAVER_LOGIN_API_INSTANCE;
	}

	
	//auth=인증요청. 네이버에 로그인요청 보낼 주소
	@Override
	protected String getAuthorizationBaseUrl() {
		String url="https://nid.naver.com/oauth2.0/authorize"; // scribejava의 Servicebuilder에서 변수값을 기본주소에 덧붙여주기때문에 기본주소만 작성
		return url;
	}
	
	//token=인증완료. 네이버가 로그인요청 처리하고 건내주는 토큰
	@Override
	public String getAccessTokenEndpoint() {
		String url="https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"; //scribejava의 Servicebuilder에서 변수값을 기본주소에 덧붙여주기때문에 기본주소만 작성
		
		return url;
	}

	
}
