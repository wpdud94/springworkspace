package com.encore.spring.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;
import com.encore.spring.model.MyProductService;

@Service
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myProductdao;
	
	@Override
	public void addProduct(MyProduct vo) throws SQLException {
		myProductdao.addProduct(vo);
	}

	@Override
	public List<MyProduct> findByProductName(String word) throws SQLException {
		return myProductdao.findByProductName(word);
	}

	@Override
	public List<MyProduct> findProducts() throws SQLException {
		return myProductdao.findProducts();
	}

}
