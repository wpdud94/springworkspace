package ibatis.services.user;

import java.sql.SQLException;
import java.util.List;

import ibatis.services.domain.User;

/*
비지니스 로직의 템플릿이 들어있다.
5개... mybatis-userservice-mapping10.xml에 있다
mapping10.xml의 쿼리문 id값이 비니지스로직의 이름
비니지스로직의 인자값은 parameterType 참조
비지니스로직의 리턴값은 resultType 참조
 */
public interface userDAO {
	int addUser(User user) throws SQLException;
	int updateUser(User user) throws SQLException;
	int removeUser(String userId) throws SQLException;
	User getUser(String userId) throws SQLException;
	List<User> getUserList(User user) throws SQLException;
}
