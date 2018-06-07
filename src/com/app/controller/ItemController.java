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

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.util.ItemUtil;

@Controller
public class ItemController {

	@Autowired
	private IItemService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ItemUtil util;
	
	/**
	 * 1. this method to show the Registration
	 *    page to register the Item	 *
	 */

	@RequestMapping("itemHome")
	public String showPage() {
		return "ItemReg";
	}
	
	/**
	 * 2. this method is used to insert the data 
	 *    into database and show the page 
	 */

	@RequestMapping(value = "insertItem", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("itemation") Item item, ModelMap map) {
		int itemId = service.saveItem(item);
		String m = "New Item has been created with Id  ::" + itemId;
		map.addAttribute("message", m);
		return "ItemReg";
	}
	
	/**
	 * 3. This method is used to select all the data form the database
	 * 	  and show the data to end-user
	 */

	@RequestMapping(value = "ViewAllItems")
	public String getAllItems(ModelMap map) {
		List<Item> items = service.getAllItems();
		map.addAttribute("Items", items);
		return "ItemData";
	}
	
	/**
	 * 4. This method is used to delete the particular data from the database
	 *    by using Item id
	 */	 

	@RequestMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemId") int itemId) {
		service.deleteItem(itemId);
		return "redirect:ViewAllItems";
	}
	
	/**
	 * 5. This method is used to get the particular data from
	 * 	  Database By taking the id from end-user
	 */
	
	@RequestMapping(value="editItem")
	public String editItem(@RequestParam("itemationId")int itemId, ModelMap map){
		Item item=null;
		item=service.getItemById(itemId);
		map.addAttribute("items",item);
		return "ItemDataEdit";
	}
	
	/**
	 * 6. This method allows the user to modify the data of database
	 *    and show them to modify data from the database
	 */
	
	@RequestMapping(value="updateItem",method=RequestMethod.POST)
	public String udpateItem(@ModelAttribute("itemation")Item item){
		service.updateItem(item);
		return "redirect:ViewAllItems";
	}
	
	/**
	 * 7. This method is used to get all data from database 
	 *    into Excel format it allows to save and view
	 *    the data into excel format
	 */
	
	@RequestMapping(value="itemExcelExport")
	public String exportToExcel(ModelMap map){
		List<Item> listItem= service.getAllItems();
		map.addAttribute("items",listItem);
	//	map.addAttribute("items",service.getAllItems());
		return "ItemExcel";
	}
	
	/**
	 * 8. This method is used to get all data from database 
	 *    into pdf format it allows to save and view
	 *    the data into pdf format
	 */
	
	@RequestMapping(value="itemPdfExport")
	public String exportToPdf(ModelMap map){
		map.addAttribute("items",service.getAllItems());
		return "ItemPdf";
	}
	/**
	 * 9. This Method is used to show Pie and Bar chart 
	 * 	  with the help of ItemUtil class Methods
	 */
	
	@RequestMapping(value="itemReport")
	public String showCharts(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getItemTypeAndCount();
		util.createPie(data, path);
		util.createBar(data, path);
		return "ItemReports";
	}
}
