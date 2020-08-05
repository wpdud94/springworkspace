package ibatis.services.user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;
import ibatis.services.user.userService;

/*
 * FileName : MyBatisTestApp12.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * ㅇ MyBatisUserDAOImpl12 / MyBatisUserServiceImpl12(이건 이름만 바꿔줌)을 작성.
  * ㅇ Spring meta data연동..userservice12.xml
  */
public class MyBatisTestApp12 {
	///Main method
	public static void main(String[] args) throws Exception{
	
	// ApplicationContext : BeanFactory
	// 이를 쓰기 위해 DI lib 5가지 사용 (Lib Module화)
	// 라이브러리 가져다 써야 한다 :: Dependancy 연결이기에
	// 최종적으로 버전이 안 맞다... mybatis <-> mybatis.spring
	/*
	의의
	1. 기업 규모의 사업에서 일일이 맞춰야 한다
	2. 신입 애들은 힘들다
	3. 대기업은 유지보수 위주. 중소기업은 직접 개발 위주.
	
	결론은 쉽지 않다
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext("/config/userservice12.xml");
								                                           
	//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
	userService userService = (userService)context.getBean("myBatisUserServiceImpl12");
	
	User user = new User("user04","주몽","user04",40,40);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//1.userService.addUser(user) Test
	System.out.println(":: 1. add(INSERT)  ? ");
	userService.addUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//2.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 2. get(SELECT)  ? "+user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//3.UserService.uadateUser(user) Test
	user.setUserName("장보고");
	System.out.println(":: 3. update(UPDATE)  ? ");
	userService.updateUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//4.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 4. get(SELECT)  ? "+user);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//5.UserDAO.removeUser(userId) Test
	//==> UserService 에는 removeUser가 없으므로, DAO에서 직접 호출 Test
	userDAO userDAO = (userDAO)context.getBean("myBatisUserDAOImpl12");
	System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user04"));
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//6.UserService.getUserList() Test
	System.out.println(":: 6. all User(SELECT)  ? ");
	List<User> list = userService.getUserList(new User());
	for (int i =0 ;  i < list.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
		System.out.println( list.get(i).toString() );
	}
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class