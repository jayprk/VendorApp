package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Item;

public class ItemExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		// read data form map
		List<Item> listItem = (List<Item>) map.get("items");

		// create Sheet
		HSSFSheet sheet = book.createSheet("Item");
		// create Header
		setHead(sheet);
		// create Body
		setBody(sheet, listItem);
	}

	public void setHead(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("MRP");
		row.createCell(4).setCellValue("MAX DISCOUNT");
		row.createCell(5).setCellValue("MFG");
		row.createCell(6).setCellValue("MODELS");
		
	}

	public void setBody(HSSFSheet sheet, List<Item> listItem) {
		int rowNum = 1;
		for (Item item : listItem) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(item.getItemId());
			row.createCell(1).setCellValue(item.getItemName());
			row.createCell(2).setCellValue(item.getItemCode());
			row.createCell(3).setCellValue(item.getItemMRP());
			row.createCell(4).setCellValue(item.getMaxDiscount());
			row.createCell(5).setCellValue(item.getItemMFG());
			row.createCell(6).setCellValue(item.getItemModels().toString());
		}
	}

}
