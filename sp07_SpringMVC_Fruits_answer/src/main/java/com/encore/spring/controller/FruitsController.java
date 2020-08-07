package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.service.ItemCatalog;

@Controller
public class FruitsController {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("index.do")
	public ModelAndView index() {
		List<Item> itemList=itemCatalog.getItemList();
		return new ModelAndView("WEB-INF/views/itemList.jsp", "itemList", itemList);
	}	
}



