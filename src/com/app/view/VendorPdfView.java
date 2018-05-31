package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//read data form ModelMap
		List<Vendor> listVen=(List<Vendor>) map.get("vens");
		//create paragraph
		Paragraph p=new Paragraph("Welcome to Vendor Pdf document\n\n",new Font(Font.TIMES_ROMAN));
		Paragraph dte=new Paragraph(new Date().toString());
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("CODE");
		table.addCell("TYPE");
		table.addCell("ADDRESS");
		table.addCell("IDTYPE");
		table.addCell("DESCRIPTION");
		
		//Add data into table
		for(Vendor ven:listVen){
			table.addCell(ven.getVenId()+"");
			table.addCell(ven.getVenName());
			table.addCell(ven.getVenCode());
			table.addCell(ven.getVenType());
			table.addCell(ven.getVenAddrs());
			table.addCell(ven.getVenIdType());
			table.addCell(ven.getVenDsc());
		}
		
		//add to elements to documents
		doc.add(p);
		doc.add(table);
		doc.add(dte);
	}

}
