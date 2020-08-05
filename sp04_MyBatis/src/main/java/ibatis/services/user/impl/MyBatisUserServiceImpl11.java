package ibatis.services.user.impl;

import java.sql.SQLException;
import java.util.List;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;
import ibatis.services.user.userService;

public class MyBatisUserServiceImpl11 implements userService{
	private userDAO userDAO;
	
	public void setUserDAO(userDAO userDAO) {
		this.userDAO = userDAO;
	}

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
