package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {
	@RequestMapping("insert.do")
	public String insert(Model model) {
		System.out.println("동기통신....");
		model.addAttribute("info", "와 동기통신이다");
		return "insert_result";
	}
	
	@RequestMapping("SearchId.do")
	public ModelAndView searchId() {
		System.out.println("비동기통신...");
		//redirect
		// return new ModelAndView("redirect:/index.jsp");
		return new ModelAndView("JsonView","person",new Person("아이유","서초동"));
	}
}
