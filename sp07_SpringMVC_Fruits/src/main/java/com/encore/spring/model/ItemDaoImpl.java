package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	final String NS = "ItemMapper.";
	
	@Override
	public List<Item> getItemList() throws SQLException {
		return sqlSession.selectList(NS+"getItemList");
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		return sqlSession.selectOne(NS+"getItem", itemId);
	}

}
