package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Location;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveCustomer(Customer cust) {
		return (int) ht.save(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}

	@Override
	public void deleteCustomer(int custId) {
		ht.delete(new Customer(custId));
	}

	@Override
	public Customer getCustomerById(int custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);
	}

	@Override
	public List<Object[]> getCustomerTypeAndCount() {
		String hql = "select custType,count(custId) from "
				+ Customer.class.getName() + " group by custType";
		List<Object[]> list = ht.find(hql);
		return list;
	}

}
