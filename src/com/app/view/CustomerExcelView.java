package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		// read data form map
		List<Customer> listCustomer = (List<Customer>) map.get("custs");

		// create Sheet
		HSSFSheet sheet = book.createSheet("Customer");
		// create Header
		setHead(sheet);
		// create Body
		setBody(sheet, listCustomer);
	}

	public void setHead(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("LOCATION");
		row.createCell(3).setCellValue("EMAIL");
		row.createCell(4).setCellValue("TYPE");
		row.createCell(5).setCellValue("ADDRESS");
		
	}

	public void setBody(HSSFSheet sheet, List<Customer> listCust) {
		int rowNum = 1;
		for (Customer cust : listCust) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(cust.getCustId());
			row.createCell(1).setCellValue(cust.getCustName());
			row.createCell(2).setCellValue(cust.getLoc().getLocName());
			row.createCell(3).setCellValue(cust.getCustEmail());
			row.createCell(4).setCellValue(cust.getCustType());
			row.createCell(5).setCellValue(cust.getCustAddrs());
		}
	}

}
