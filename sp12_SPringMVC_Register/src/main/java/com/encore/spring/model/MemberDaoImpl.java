package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	/*
	 * public void setSqlSession(SqlSession sqlSession) { this.sqlSession =
	 * sqlSession; }
	 */

	final String NS = "MemberMapper.";
	
	@Override
	public List<Member> showAllMember() throws SQLException {
		return sqlSession.selectList(NS+"showAllMember");
	}

	@Override
	public Member showMember(String id) throws SQLException {
		return sqlSession.selectOne(NS+"showMember",id);
	}

	@Override
	public void addMember(Member vo) throws SQLException {
		sqlSession.insert(NS+"addMember",vo);
	}

	@Override
	public void updateMember(Member vo) throws SQLException {
		sqlSession.update(NS+"updateMember",vo);
	}

	@Override
	public Member login(Member vo) throws SQLException {
		return sqlSession.selectOne(NS+"login",vo);
	}

}
