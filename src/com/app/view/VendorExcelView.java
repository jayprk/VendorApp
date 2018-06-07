package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;
import com.app.model.Vendor;

public class VendorExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		// read data form map
		List<Vendor> listVendor = (List<Vendor>) map.get("vens");

		// create Sheet
		HSSFSheet sheet = book.createSheet("Vendor");
		// create Header
		setHead(sheet);
		// create Body
		setBody(sheet, listVendor);
	}

	public void setHead(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("LOCATION");
		row.createCell(4).setCellValue("LOC TYPE");
		row.createCell(5).setCellValue("VEN TYPE");
		row.createCell(6).setCellValue("ADDRESS");
		row.createCell(7).setCellValue("IDTYPE");
		row.createCell(8).setCellValue("ID NUM");
		row.createCell(9).setCellValue("DESCRIPATION");
	}

	public void setBody(HSSFSheet sheet, List<Vendor> listVen) {
		int rowNum = 1;
		for (Vendor ven : listVen) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ven.getVenId());
			row.createCell(1).setCellValue(ven.getVenName());
			row.createCell(2).setCellValue(ven.getVenCode());
			row.createCell(3).setCellValue(ven.getLoc().getLocName());
			row.createCell(4).setCellValue(ven.getLoc().getLocType());
			row.createCell(5).setCellValue(ven.getVenType());
			row.createCell(6).setCellValue(ven.getVenAddrs());
			row.createCell(7).setCellValue(ven.getVenIdType());
			row.createCell(8).setCellValue(ven.getVenIdNum());
			row.createCell(9).setCellValue(ven.getVenDsc());
		}
	}

}
