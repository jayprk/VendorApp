package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//read data form ModelMap
		List<Item> listItem=(List<Item>) map.get("items");
		//create paragraph
		Paragraph p=new Paragraph("Welcome to Item Pdf document\n\n",new Font(Font.TIMES_ROMAN));
		Paragraph dte=new Paragraph(new Date().toString());
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("CODE");
		table.addCell("MRP");
		table.addCell("MAX DISCOUNT");
		table.addCell("MFG");
		table.addCell("MODELS");
		
		
		//Add data into table
		for(Item item:listItem){
			table.addCell(item.getItemId()+"");
			table.addCell(item.getItemName());
			table.addCell(item.getItemCode());
			table.addCell(item.getItemMRP()+"");
			table.addCell(item.getMaxDiscount()+"");
			table.addCell(item.getItemMFG());
			table.addCell(item.getItemModels().toString());
			
		}
		
		//add to elements to documents
		doc.add(p);
		doc.add(table);
		doc.add(dte);
	}

}
