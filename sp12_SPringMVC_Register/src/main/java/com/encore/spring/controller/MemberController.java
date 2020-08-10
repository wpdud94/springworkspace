package com.encore.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Member;
import com.encore.spring.service.MemberSerivce;
import com.encore.spring.test.MemeberServiceTest;

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
	public ModelAndView login(HttpServletRequest request, Member vo) throws SQLException{
		//String id = request.getParameter("id");
		Member mvo = memberService.login(vo);
		request.getSession().setAttribute("vo", mvo);
		return new ModelAndView("login_result.jsp");
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
	public String idCheck(String id, Model model) throws SQLException{
		boolean flag = false;
		System.out.println(id);
		if(memberService.showMember(id)!=null) flag=true;
		model.addAttribute("flag",flag);
		return "update_result";
	}
}
