package com.encore.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;
/*
 * FactoryService 사용
 */
public class SimpleMyBatisAppTest3 {

	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory=FactoryService.getFactory();
		SqlSession session=factory.openSession();
		List<MySawon> sawonlist=session.selectList("mysawonMapper.sawonList");
		for (MySawon sawon:sawonlist) {
			System.out.println(sawon);
	}
	}
}
