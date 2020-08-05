package ibatis.services.user.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;
import ibatis.services.user.userService;

@Service
public class MyBatisUserServiceImpl13 implements userService{
	
	@Autowired
	private userDAO userDAO;

	@Override
	public void addUser(User user) throws SQLException {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		userDAO.updateUser(user);
	}

	@Override
	public User getUser(String userId) throws SQLException {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList(User user) throws SQLException {
		return userDAO.getUserList(user);
	}

}
