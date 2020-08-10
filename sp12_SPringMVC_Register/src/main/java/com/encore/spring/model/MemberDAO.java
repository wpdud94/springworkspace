package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberDAO {
	List<Member> showAllMember() throws SQLException;
	Member showMember(String id) throws SQLException;
	void addMember(Member vo) throws SQLException;
	void updateMember(Member vo) throws SQLException;
	Member login(Member vo) throws SQLException;
}
