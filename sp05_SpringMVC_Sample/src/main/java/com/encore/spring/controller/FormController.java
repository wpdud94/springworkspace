package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		Form값 받아서 
		VO 생성
		Service 호출
		리턴된 값 받아서
		바인딩 to mv
		 */
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
	
		return new ModelAndView("form_result", "info", name+", "+addr);
	}

}
