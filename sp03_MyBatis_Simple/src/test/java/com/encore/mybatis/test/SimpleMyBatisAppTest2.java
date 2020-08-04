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
 * mysawon 테이블에 있는 모든 사원의 정보를 출력하는 코드를 작성
 */
public class SimpleMyBatisAppTest2 {

	public static void main(String[] args) throws IOException {
		Reader r =Resources.getResourceAsReader("config/sqlMapConfig.xml");
		SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(r);
		SqlSession session=factory.openSession();
		
		List<MySawon> sawonlist=session.selectList("mysawonMapper.sawonList");
		session.commit();
		session.close();
		for (MySawon sawon:sawonlist) System.out.println(sawon);
	}

}
