package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(); // 뷰페이지이름, 이동경로지정 + 데이터 바인딩
		mv.setViewName("result"); // 확장자 쓰지 않음 + 물리적인 저장 위치 쓰지 않음 --> ViewResolver 가 알아서 함 : WEB-INF/views/result.jsp
		mv.addObject("message", "Hello First SpringMVC");
		return mv;
	}
	
}
