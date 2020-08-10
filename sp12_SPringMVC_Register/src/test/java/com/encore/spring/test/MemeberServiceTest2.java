package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;
import com.encore.spring.model.MemberDaoImpl;

public class MemeberServiceTest2 {
	
	@Test
	public void unit() throws IOException, SQLException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		MemberDaoImpl dao = new MemberDaoImpl();
		String NS = "MemberMapper.";
		//dao.setSqlSession(session);
		//showAllMemeber
		List<Member> members =dao.showAllMember();
		System.out.println("showAllMember ================");
		for(Member member : members) System.out.println(member);
		
		//addMember
		System.out.println("addMember ================ \n pass");
		/*
		 * System.out.println(session.insert("addMember", new Member("111", "aaa",
		 * "sdds", "미국"))); session.commit();
		 */
		
		//updateMember
		System.out.println("updateMember ================ ");
		dao.updateMember(new Member("korea", "장나라", "1122", "미국"));

		//showMember
		System.out.println("showMember ================");
		System.out.println(dao.showMember("korea"));
		
		
	}
}
