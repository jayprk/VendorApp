package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	public int saveItem(Item item);
	public List<Item> getAllItems();
	public void deleteItem(int itemId);
	
	public void updateItem(Item item);
	public Item getItemById(int itemId);
	public List<Object[]> getItemTypeAndCount();
}
