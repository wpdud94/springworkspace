package com.encore.spring.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String ns = "ProductMapper.";
	
	@Override
	public void addProduct(MyProduct vo) throws SQLException {
		sqlSession.insert(ns+"addProduct", vo);
	}

	@Override
	public List<MyProduct> findByProductName(String word) throws SQLException {
		return sqlSession.selectList(ns+"findByProductName", word);
	}

	@Override
	public List<MyProduct> findProducts() throws SQLException {
		return sqlSession.selectList(ns+"findProducts");
	}

}
