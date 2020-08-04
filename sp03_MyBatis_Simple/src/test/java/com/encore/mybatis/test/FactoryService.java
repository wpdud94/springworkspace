package com.encore.mybatis.test;
/*
 * SqlSessionFactory 하나 받아오는 로직을 따로 분리
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader r =Resources.getResourceAsReader("config/sqlMapConfig.xml");
			factory =new SqlSessionFactoryBuilder().build(r);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
