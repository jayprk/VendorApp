package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.model.Location;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveItem(Item item) {
		return (int) ht.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

	@Override
	public void deleteItem(int itemId) {
		ht.delete(new Item(itemId));
	}

	@Override
	public Item getItemById(int itemId) {
		return ht.get(Item.class, itemId);
	}

	@Override
	public void updateItem(Item item) {
		ht.update(item);
	}

	@Override
	public List<Object[]> getItemTypeAndCount() {
		String hql = " select cust.custName,count(cust.custName) "
				+ " from com.app.model.Item item " + " inner join "
				+ " item.cust as cust " + " group by cust.custName ";
		List<Object[]> list=ht.find(hql);
		 

		/*String hql = "select locType,count(locId) from "
				+ Location.class.getName() + " group by locType";
		List<Object[]> list = ht.find(hql);*/
		return list;

	}

}
