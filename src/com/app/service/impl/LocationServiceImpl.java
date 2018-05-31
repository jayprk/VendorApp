package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService {
	
	@Autowired
	private ILocationDao dao;
	
	@Override
	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);		
	}

	@Override
	public void updateLocation(Location loc) {
		dao.updateLocation(loc);
	}

	@Override
	public void deleteLocation(int locId) {
		dao.deleteLocation(locId);
	}

	@Override
	public Location getLocationById(int locId) {
		Location l=null;
		l=dao.getLocationById(locId);
		return l;
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> locs=null;
		locs=dao.getAllLocations();
		Collections.sort(locs,new Comparator<Location>() {

			@Override
			public int compare(Location o1, Location o2) {
				return o1.getLocId()-o2.getLocId();
			}			
		});
		return locs;
	}

	@Override
	public List<Object[]> getLocationTypeAndCount() {
		return dao.getLocationTypeAndCount();
		
	}

}
