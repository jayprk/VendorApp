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

public class LocationExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//0. for file name
		res.addHeader("Content-Disposition","attachment;filename=LOCATION.xls");
		
		//1. read data from model map
		List<Location> locs=(List<Location>)map.get("locs");
		
		//2. create sheet
		HSSFSheet sheet=book.createSheet("Location");
		//3. const header
		setHead(sheet);		
		//4. const Body
		setBody(sheet,locs);
	}
	
	public void setHead(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("DESC");
	}
	
	public void setBody(HSSFSheet sheet,List<Location> locs){
		int rowNum=1;
		
		for(Location loc:locs){
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(loc.getLocId());
			row.createCell(1).setCellValue(loc.getLocName());
			row.createCell(2).setCellValue(loc.getLocCode());
			row.createCell(3).setCellValue(loc.getLocType());
			row.createCell(4).setCellValue(loc.getLocDesc());
		}
	}

}
