package com.encore.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDao;

@Service
public class ItemCatalogeImpl implements ItemCataloge {
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getItemList() throws SQLException {
		return itemDao.getItemList();
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		return itemDao.getItem(itemId);
	}
	
}
