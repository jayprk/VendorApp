package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao{
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);		
	}

	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
		
	}
	@Override
	public void deleteLocation(int locId) {		
		ht.delete(new Location(locId));		
	}

	@Override
	public Location getLocationById(int locId) {
		Location loc=ht.get(Location.class,locId);		
		return loc;
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> locs=ht.loadAll(Location.class);
		return locs;
	}

	@Override
	public List<Object[]> getLocationTypeAndCount() {
		String hql="select locType,count(locId) from "+Location.class.getName()+" group by locType";
		List<Object[]> list=ht.find(hql);
		return list;
	}

}
