package com.encore.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements IPhoneDAO{
	@Autowired
	private SqlSession sqlSession;
	
	final String NS = "sql.pms.mapper";
	
	public int insert(Phone phone) {
		return sqlSession.insert(NS+"insert", phone);
	}

	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete", list);
	}

	public Phone select(Phone phone) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"select", phone);
	}

	public List<Phone> select() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"select", null);
	}

	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"selectUser", user);
	}
	
	
}
