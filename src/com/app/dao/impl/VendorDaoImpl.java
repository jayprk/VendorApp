package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao{
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveVendor(Vendor ven) {
		return (Integer)ht.save(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		ht.update(ven);
	}

	@Override
	public void deleteVendor(int venId) {
		Vendor ven=new Vendor();
		ven.setVenId(venId);
		ht.delete(ven);
	}

	@Override
	public Vendor getVendorById(int venId) {
		return ht.get(Vendor.class,venId);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return ht.loadAll(Vendor.class);
	}

	@Override
	public List<Object[]> getVendorTypeAndCount() {
		String hql= " select loc.locName,count(loc.locName) " +
				" from com.app.model.Vendor ven " +
				" inner join " +
				" ven.loc as loc " +
				" group by loc.locName ";
	List<Object[]> list=ht.find(hql);
			return list;
	}

	
}
