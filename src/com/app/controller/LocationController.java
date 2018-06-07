package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;

@Controller
public class LocationController {

	@Autowired
	private ILocationService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private LocationUtil util;
	
	/**
	 * 1. this method to show the Registration
	 *    page to register the Location	 *
	 */

	@RequestMapping("locHome")
	public String showPage() {
		return "LocationReg";
	}
	
	/**
	 * 2. this method is used to insert the data 
	 *    into database and show the page 
	 */

	@RequestMapping(value = "insertLoc", method = RequestMethod.POST)
	public String saveLoc(@ModelAttribute("location") Location loc, ModelMap map) {
		int locId = service.saveLocation(loc);
		String m = "New Location has been created with Id  ::" + locId;
		map.addAttribute("message", m);
		return "LocationReg";
	}
	
	/**
	 * 3. This method is used to select all the data form the database
	 * 	  and show the data to end-user
	 */

	@RequestMapping(value = "ViewAllLocs")
	public String getAllLocs(ModelMap map) {
		List<Location> locs = service.getAllLocations();
		map.addAttribute("Locs", locs);
		return "LocationData";
	}
	
	/**
	 * 4. This method is used to delete the particular data from the database
	 *    by using Location id
	 */	 

	@RequestMapping("/deleteLoc")
	public String deleteLoc(@RequestParam("locId") int locId) {
		service.deleteLocation(locId);
		return "redirect:ViewAllLocs";
	}
	
	/**
	 * 5. This method is used to get the particular data from
	 * 	  Database By taking the id from end-user
	 */
	
	@RequestMapping(value="editLoc")
	public String editLocation(@RequestParam("locationId")int locId, ModelMap map){
		Location loc=null;
		loc=service.getLocationById(locId);
		map.addAttribute("locs",loc);
		return "LocationDataEdit";
	}
	
	/**
	 * 6. This method allows the user to modify the data of database
	 *    and show them to modify data from the database
	 */
	
	@RequestMapping(value="updateLoc",method=RequestMethod.POST)
	public String udpateLocation(@ModelAttribute("location")Location loc){
		service.updateLocation(loc);
		return "redirect:ViewAllLocs";
	}
	
	/**
	 * 7. This method is used to get all data from database 
	 *    into Excel format it allows to save and view
	 *    the data into excel format
	 */
	
	@RequestMapping(value="locExcelExport")
	public String exportToExcel(ModelMap map){
		List<Location> listLocation= service.getAllLocations();
		map.addAttribute("locs",listLocation);
	//	map.addAttribute("locs",service.getAllLocations());
		return "LocExcel";
	}
	
	/**
	 * 8. This method is used to get all data from database 
	 *    into pdf format it allows to save and view
	 *    the data into pdf format
	 */
	
	@RequestMapping(value="locPdfExport")
	public String exportToPdf(ModelMap map){
		map.addAttribute("locs",service.getAllLocations());
		return "LocPdf";
	}
	/**
	 * 9. This Method is used to show Pie and Bar chart 
	 * 	  with the help of LocationUtil class Methods
	 */
	
	@RequestMapping(value="locReport")
	public String showCharts(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getLocationTypeAndCount();
		util.createPie(data, path);
		util.createBar(data, path);
		return "LocationReports";
	}
}
