package com.encore.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Member;
import com.encore.spring.service.MemberSerivce;
import com.encore.spring.test.MemeberServiceTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MemberController {
	@Autowired
	private MemberSerivce memberService;
	
	@RequestMapping("allMember.do")
	public String allMember(Model model) throws SQLException{
		List<Member> list = memberService.showAllMember();
		model.addAttribute("list",list);
		return "allView";
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, Member vo) throws SQLException{
		//String id = request.getParameter("id");
		Member mvo = memberService.login(vo);
		request.getSession().setAttribute("vo", mvo);
		return "login_result";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws SQLException{
		request.getSession().invalidate();
		return "logout";
	}
	
	@RequestMapping("find.do")
	public String find(HttpServletRequest request, Model model) throws SQLException{
		String id = request.getParameter("id");
		Member mvo = memberService.showMember(id);
		if(mvo!=null) {
			model.addAttribute("vo",mvo);
			return "find_ok";
		}
		return "find_fail";
	}
	
	@RequestMapping("update.do")
	public String update(String id, String name, String address, String password
			,Model model) throws SQLException{
		Member vo = new Member(id, name, password, address);
		System.out.println(vo);
		memberService.updateMember(vo);
		model.addAttribute("vo",vo);
		return "update_result";
	}
	
	@RequestMapping("idCheck.do")
	public void idCheck(String id, HttpServletResponse response) throws SQLException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		Member member = memberService.showMember(id);
		boolean flag = false;
		if(member!=null) flag = true;
		String jsonString = mapper.writeValueAsString(flag);
		System.out.println(flag);
		try {
			response.getWriter().print(jsonString);
		} catch (IOException e) {
			System.out.println("Writer 문제");
		}
	}
	
	@RequestMapping("register.do")
	public ModelAndView register(String id, String name, String password, String address) throws SQLException{
		memberService.addMember(new Member(id, name, password, address));
		return new ModelAndView("redirect:index.jsp");
	}
}
