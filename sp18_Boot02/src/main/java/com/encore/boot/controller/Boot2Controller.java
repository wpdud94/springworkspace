package com.encore.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Boot2Controller {
	
	// jsp와 Maven이 돌아가는지 확인
	@GetMapping("/index")
	public String sayHello(Model model) {
		model.addAttribute("data","encore, say Hello!!!");
		return "result";
	}
}
