package com.encore.mybatis.test;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

/* Scanner를 통해서 값을 입력 (화면을 대신)
 * 입력받은 값을 MyBatis 라이브러리를 사용해서 DB에 Access하는 로직 작성
 */
public class SimpleMyBatisAppTest {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	//받은 값을 vo에 setter로 주입
	MySawon vo=new MySawon();
	System.out.println("id 입력");
	vo.setId(sc.next());
	System.out.println("비밀번호 입력");
	vo.setPwd(sc.next());
	System.out.println("이름 입력");
	vo.setName(sc.next());
	System.out.println("나이 입력");
	vo.setAge(sc.nextInt());
	
	// MyBatis 라이브러리 사용
	try {
		//1.SqlMapConfig.xml을 읽어들인다
		Reader r=Resources.getResourceAsReader("config/sqlMapConfig.xml");
		
		//2.sqlSessionFactory 리턴
		SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(r);
		
		//3. sqlSession 리턴
		SqlSession session=factory.openSession();
		
		//4. Query문을 실행하는 모든 기능이 session에 있다
		// insert,delete,select,update,selectList,selectOne
		session.insert("mysawonMapper.sawonAdd",vo);
		session.commit();//dml일때는 반드시
		session.close();
		
		System.out.println(vo.getName()+" 님 정보 입력 성공^^");
	}catch (Exception e) {
		System.out.println(vo.getName()+" 님 정보 입력 실패^^");	
		}
	}
}
