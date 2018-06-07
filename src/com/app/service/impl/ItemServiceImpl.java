package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private IItemDao dao;

	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> listCust=dao.getAllItems();
		Collections.sort(listCust, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getItemId()-o2.getItemId();
			}
		});
		return listCust;
	}

	@Override
	public void deleteItem(int itemId) {
		dao.deleteItem(itemId);
	}

	@Override
	public Item getItemById(int itemId) {
		return dao.getItemById(itemId);
	}

	@Override
	public void updateItem(Item item) {
		dao.updateItem(item);
	}

	@Override
	public List<Object[]> getItemTypeAndCount() {
		return dao.getItemTypeAndCount();
	}

}
