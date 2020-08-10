package com.encore.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;

@Service
public class MemberServiceImpl implements MemberSerivce{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<Member> showAllMember() throws SQLException {
		return memberDAO.showAllMember();
	}

	@Override
	public Member showMember(String id) throws SQLException {
		return memberDAO.showMember(id);
	}

	@Override
	public void addMember(Member vo) throws SQLException {
		memberDAO.addMember(vo);
	}

	@Override
	public void updateMember(Member vo) throws SQLException {
		memberDAO.updateMember(vo);
	}

	@Override
	public Member login(Member vo) throws SQLException {
		return memberDAO.login(vo);
	}

}
