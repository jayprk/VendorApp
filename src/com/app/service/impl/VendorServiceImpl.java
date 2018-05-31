package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
	
	@Autowired
	private IVendorDao dao;

	@Override
	public int saveVendor(Vendor ven) {
		return dao.saveVendor(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);
	}

	@Override
	public void deleteVendor(int venId) {
		dao.deleteVendor(venId);
	}

	@Override
	public Vendor getVendorById(int venId) {
		return dao.getVendorById(venId);
	}

	@Override
	public List<Vendor> getAllVendor() {
		List<Vendor> listVen=dao.getAllVendor();
		Collections.sort(listVen,new Comparator<Vendor>() {

			@Override
			public int compare(Vendor o1, Vendor o2) {
				return o1.getVenId()-o2.getVenId();
			}
		});
		return listVen;
	}

	@Override
	public List<Object[]> getVendorTypeAndCount() {
		return dao.getVendorTypeAndCount();
	}

	
}
