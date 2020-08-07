package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemDao {
	List<Item> getItemList() throws SQLException;
	Item getItem(int itemId) throws SQLException;
}
