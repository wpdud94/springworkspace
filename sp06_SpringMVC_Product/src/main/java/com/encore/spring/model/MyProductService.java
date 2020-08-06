package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductService {
	void addProduct(MyProduct vo) throws SQLException;
	List<MyProduct> findByProductName(String name) throws SQLException;
	List<MyProduct> findProducts() throws SQLException;
}
