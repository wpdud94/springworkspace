package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class MyBatisUnitTest2 {
	
	@Test
	public void unit() throws Exception{
		//1. 설정문서 읽기
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. 팩토리
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. 세션
		SqlSession session = factory.openSession();
		
		//4. 그릇
		MyProduct vo = new MyProduct("통돌이 세탁기", "LG", 800000);
		MyProduct vo2 = new MyProduct("드럼 세탁기", "Samsung", 900000);
		MyProduct vo3 = new MyProduct("6모션 세탁기", "Hwaway", 700000);
		System.out.println("DB Before : "+vo.getId()); //DB 넣기 전이므로 0
		
		// insert
		/*
		 * session.insert("ProductMapper.addProduct", vo); // DB에 값 넣고 + id값 자동생성 +
		 * 자동생성된 id를 VO에 setting session.insert("ProductMapper.addProduct", vo2);
		 * session.insert("ProductMapper.addProduct", vo3);
		 */
		
		System.out.println("DB after : "+vo.getId()); //DB 넣은 후라서  1.. 미리 해놨기에 이후에 바로 쓸 수 있다... select이런 거 없이
		session.commit(); // MyBatis만 돌아가기에 이거 다 해줘야 함
		
		// findByProductName
		System.out.println("findByProductName =====================");
		List<MyProduct> plist = session.selectList("ProductMapper.findByProductName", "드럼");
		for(MyProduct a : plist) System.out.println(a);
		
		// findProducts
		System.out.println("findProducts =====================");
		List<MyProduct> plist2 = session.selectList("ProductMapper.findProducts");
		for(MyProduct b : plist2) System.out.println(b);
	}

}
