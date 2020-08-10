package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;

public class MemeberServiceTest {
	
	@Test
	public void unit() throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String NS = "MemberMapper.";
		
		//showAllMemeber
		List<Member> members =session.selectList(NS+"showAllMember");
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
		session.update("updateMember", new Member("111", "aaa", "sdds", "캐나다"));
		session.commit();

		//showMember
		System.out.println("showMember ================");
		System.out.println(session.selectOne(NS+"showMember", "111"));
		
		//login
		System.out.println("login ================");
		//ㅈSystem.out.println(session.selectOne(NS+"login",new Member("111", "aba", "sdds", "캐나다")));
		
		
	}
}
