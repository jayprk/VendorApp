package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;

	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> listCust=dao.getAllCustomers();
		Collections.sort(listCust, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getCustId()-o2.getCustId();
			}
		});
		return listCust;
	}

	@Override
	public void deleteCustomer(int custId) {
		dao.deleteCustomer(custId);
	}

	@Override
	public Customer getCustomerById(int custId) {
		return dao.getCustomerById(custId);
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public List<Object[]> getCustomerTypeAndCount() {
		return dao.getCustomerTypeAndCount();
	}

}
