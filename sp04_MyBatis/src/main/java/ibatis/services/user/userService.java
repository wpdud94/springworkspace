package ibatis.services.user;

import java.sql.SQLException;
import java.util.List;

import ibatis.services.domain.User;
/*
데이터 가공 레이어
제일 연관없는 거 빼기 :: remove
때에 따라 리턴타입 변경
 */
public interface userService {
	void addUser(User user) throws SQLException;
	void updateUser(User user) throws SQLException;
	User getUser(String userId) throws SQLException;
	List<User> getUserList(User user) throws SQLException;
}
