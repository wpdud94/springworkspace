package com.encore.spring.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping(value="myProduct.do", method=RequestMethod.POST)
	public ModelAndView insert(MyProduct pvo) throws SQLException {
		System.out.println("폼으로 받은 데이터"+ pvo.getId());//0
		/*
		폼에 입력되면 Dispatcher->HandlerMapping->Dis->Controller로 오는데
		이때, 폼의 이름과 필드명이 일치해야 함.
		값이 알아서 입력됨
		
		request.getParameter 할 필요없다
		 */
		myProductService.addProduct(pvo);
		
		System.out.println("폼으로 받은 데이터"+ pvo.getId());//4
		
		return new ModelAndView("insert_result", "info", pvo);
	}
	
	@RequestMapping(value="mySearch.do", method=RequestMethod.POST)
	public ModelAndView search(String word) throws SQLException {
		List<MyProduct> list = myProductService.findByProductName(word);
		
		return new ModelAndView("find_result", "list", list);
	}
}
