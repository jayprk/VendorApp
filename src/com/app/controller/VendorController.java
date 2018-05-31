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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.VendorUtil;

@Controller
public class VendorController {

	@Autowired
	private IVendorService service;
	
	@Autowired
	private VendorUtil util;
	
	@Autowired
	private ServletContext context;

	@RequestMapping(value = "venHome")
	public String showReg(ModelMap map) {
		util.addUiComponents(map);
		return "VendorReg";
	}

	@RequestMapping(value = "insertVendor", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor") Vendor ven, ModelMap map) {
		int venId = service.saveVendor(ven);
		String msg = "Vendor Record Successfully Inserted with Id::" + venId;
		map.addAttribute("Msg", msg);
		return "VendorReg";
	}

	@RequestMapping(value = "viewAllVendor")
	public String showAllVendor(ModelMap map) {
		List<Vendor> listVen = service.getAllVendor();
		map.addAttribute("Vens", listVen);
		util.addUiComponents(map);
		return "VendorData";
	}

	@RequestMapping(value="deleteVender")
	public String deleteVendor(@RequestParam("venId") int venId) {
		service.deleteVendor(venId);
		return "redirect:viewAllVendor";
	}

	@RequestMapping("editVender")
	public String editVendor(@RequestParam("venId") int venId, ModelMap map) {
		Vendor ven = null;
		ven = service.getVendorById(venId);
		map.addAttribute("ven", ven);
		util.addUiComponents(map);
		return "VendorDataEdit";
	}

	@RequestMapping(value = "updateVen", method = RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor") Vendor ven) {
		service.updateVendor(ven);
		return "redirect:viewAllVendor";
	}

	@RequestMapping("venExelExport")
	public String venExcelExport(ModelMap map) {
		map.addAttribute("vens", service.getAllVendor());
		return "venExcel";
	}

	@RequestMapping("venPdfExport")
	public String venPdfExport(ModelMap map) {
		map.addAttribute("vens", service.getAllVendor());
		return "venPdf";
	}
	
	@RequestMapping(value="venReport")
	public String showCharts(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getVendorTypeAndCount();
		util.createPie(data, path);
		util.createBar(data, path);
		return "VendorReports";
	}
}
