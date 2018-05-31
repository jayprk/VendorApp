package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.util.CustomerUtil;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@Autowired
	private CodeUtil codeUtil;

	@Autowired
	private CoDecUtil coDecUtil;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private CustomerUtil util;

	@Autowired
	private ServletContext context;

	@RequestMapping("/custReg")
	public String showReg(ModelMap map) {
		util.addUiComponents(map);
		return "CustomerReg";
	}

	@RequestMapping(value = "insertCust", method = POST)
	public String saveCust(@ModelAttribute("customer") Customer cust,
			ModelMap map) {
		// generate pwd and token
		String tkn = CodeUtil.genToken();
		String pwd = CodeUtil.genPwd();

		// encode details
		String encTkn = CoDecUtil.doEncode(tkn);
		String encPwd = CoDecUtil.doEncode(pwd);
		// set encoded details to customer
		cust.setCustToken(encTkn);
		cust.setcPassword(encPwd);
		// save customer
		int custId = service.saveCustomer(cust);

		// email coding
		String text = "Welcome to Customer " + cust.getCustName()
				+ " \nYour Id is " + cust.getCustId() + " \nToken is " + tkn
				+ " \nPassword is " + pwd;
		commonUtil.sendEmail(cust.getCustEmail(), "Registration Details", text);
		// message to UI
		String msg = "Register with Id " + custId;
		map.addAttribute("message", msg);
		return "CustomerReg";

	}

	@RequestMapping(value = "ViewAllCust")
	public String getAllCust(ModelMap map) {
		List<Customer> custs = service.getAllCustomers();
		map.addAttribute("custs", custs);
		return "CustomerData";
	}

	@RequestMapping("deleteCust")
	public String deleteCust(@RequestParam("custId") int custId) {
		service.deleteCustomer(custId);
		return "redirect:ViewAllCust";
	}

	@RequestMapping(value = "editCust")
	public String editCustomer(@RequestParam("customerId") int custId,
			ModelMap map) {
		Customer cust = null;
		cust = service.getCustomerById(custId);
		map.addAttribute("custs", cust);
		return "CustomerDataEdit";
	}

	@RequestMapping(value = "updateCust", method = POST)
	public String udpateCustomer(@ModelAttribute("customer") Customer cust) {
		service.updateCustomer(cust);
		return "redirect:ViewAllCust";
	}

	@RequestMapping(value = "custPdfExport")
	public String exportToPdf(ModelMap map) {
		map.addAttribute("cust", service.getAllCustomers());
		return "custPdf";
	}

	@RequestMapping(value = "custReport")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> data = service.getCustomerTypeAndCount();
		util.createPie(data, path);
		util.createBar(data, path);
		return "CustomerReports";
	}
}
