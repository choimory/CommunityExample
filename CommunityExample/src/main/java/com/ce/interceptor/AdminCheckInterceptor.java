package com.ce.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ce.dto.MemberDTO;

public class AdminCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = true;
		MemberDTO memberDto = (MemberDTO) request.getSession().getAttribute("memberDto");

		if (memberDto == null) {
			response.sendRedirect("/communityexample/main");
			result = false;
		} else if (memberDto != null) {
			if (memberDto.getMemberInfoDto().getmAdmin() == null) {
				response.sendRedirect("/communityexample/main");
				result = false;
			} 
		}

		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
