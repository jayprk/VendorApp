package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//0. for file name
		res.addHeader("Content-Disposition","attachment;filename=LOCATION.pdf");
		
		//1.Read data form map
			List<Location> locs=(List<Location>)map.get("locs");
		//2.create element
			Paragraph p=new Paragraph("Welcome to Location pdf file");
			Paragraph dte=new Paragraph(new Date().toString());
			PdfPTable table=new PdfPTable(5);
			table.addCell("ID");
			table.addCell("NAME");
			table.addCell("TYPE");
			table.addCell("CODE");
			table.addCell("DESC");
			
			//Adding List data to Table
			for(Location loc:locs){
				table.addCell(loc.getLocId()+"");
				table.addCell(loc.getLocName());				
				table.addCell(loc.getLocType());
				table.addCell(loc.getLocCode());
				table.addCell(loc.getLocDesc());
			}
			
			
		//3.add element to document
			doc.add(p);
			doc.add(table);
			doc.add(dte);
	}

}
