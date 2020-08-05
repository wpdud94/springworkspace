package ibatis.services.user.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;


/*
Persistence Layer Component(Bean)
SqlSession을 Hasing하는 클래스
1) 필드에 SqlSession 선언
2) setter로 주입
 */

@Repository
public class MyBatisUserDAOImpl13 implements userDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addUser(User user) throws SQLException {
		int result = sqlSession.insert("UserMapper10.addUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		return sqlSession.update("UserMapper10.updateUser",user);
	}

	@Override
	public int removeUser(String userId) throws SQLException {
		return sqlSession.delete("UserMapper10.removeUser", userId);
	}

	@Override
	public User getUser(String userId) throws SQLException {
		return sqlSession.selectOne("UserMapper10.getUser",userId);
	}

	@Override
	public List<User> getUserList(User user) throws SQLException {
		return sqlSession.selectList("UserMapper10.getUserList", user);
	}
	
}
