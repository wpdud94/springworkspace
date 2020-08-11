package com.encore.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService iPhoneService;
	
}
