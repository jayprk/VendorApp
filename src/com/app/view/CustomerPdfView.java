package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//read data form ModelMap
		List<Customer> listCust=(List<Customer>) map.get("custs");
		//create paragraph
		Paragraph p=new Paragraph("Welcome to Customer Pdf document\n\n",new Font(Font.TIMES_ROMAN));
		Paragraph dte=new Paragraph(new Date().toString());
		PdfPTable table=new PdfPTable(10);
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("LOCATION");
		table.addCell("EMAIL");
		table.addCell("TYPE");
		table.addCell("ADDRESS");
		
		
		//Add data into table
		for(Customer cust:listCust){
			table.addCell(cust.getCustId()+"");
			table.addCell(cust.getCustName());
			table.addCell(cust.getLoc().getLocName());
			table.addCell(cust.getLoc().getLocType());
			table.addCell(cust.getCustEmail());
			table.addCell(cust.getCustType());
			table.addCell(cust.getCustAddrs());
			
		}
		
		//add to elements to documents
		doc.add(p);
		doc.add(table);
		doc.add(dte);
	}

}
