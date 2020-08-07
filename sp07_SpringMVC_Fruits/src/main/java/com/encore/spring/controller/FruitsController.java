package com.encore.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.service.ItemCataloge;

@Controller
public class FruitsController {
	@Autowired
	private ItemCataloge itemCataloge;
	
	@RequestMapping(value="index.do")
	public ModelAndView index() throws SQLException{
		List<Item> list = itemCataloge.getItemList();
		return new ModelAndView("itemList","list",list);
	}
	
	@RequestMapping(value="itemInfo.do")
	public ModelAndView itemInfo(HttpServletRequest request) throws SQLException{
		int itemId = Integer.parseInt(request.getParameter("itemNumber"));
		return new ModelAndView("itemInfo","item",itemCataloge.getItem(itemId));
	}
}
