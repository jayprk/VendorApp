package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Path("/item")
@Component
public class ItemServiceProvider {
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator validator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService service;
	
	@POST
	@Path("/save")
	public String saveItem(
			@HeaderParam("username")String un,
			@HeaderParam("password")String pwd,
			@HeaderParam("token")String token,
			String itemJson	) {
		
		//1. basic validations
		if(un==null || "".equals(un.trim())){
			return "Empty Username provided";
		}
		if(pwd==null || "".equals(pwd.trim())){
			return "Empty Password provided";
		}
		if(token==null || "".equals(token.trim())){
			return "Empty token provided";
		}
		if(itemJson ==null || "".equals(itemJson.trim())){
			return "Empty Item(JSON) provided";
		}
		//2. cust(email)Id exist or not?
		Customer cust=custService.getCustomerByEmailId(un);
		if(cust==null){
			return "Invalid username(not exist) provided";
		}
		//3. validate pwd,token
		boolean flag=validator.isPwdAndTokenValid(pwd, token, cust);
		//if(flag==false)
		if(!flag){
			return "Invalid Password/Token provided";
		}
		flag=validator.isCustTypeSeller(cust);
		if(!flag){
			return "Customer Type(Consumer) can not do this operation";
		}
		//4. JSON->Item
		Object ob=jsonUtil.jsonToObj(itemJson, Item.class);
		Item item=null;
		if(ob instanceof Item){ //to avoid ClassCastException
			item=(Item)ob;
			
		}
		item.setCustId(cust.getCustId());
		//5. save Item
		int itemId=service.saveItem(item);
		String message="Item '"+itemId+"' saved";
		
		return message;
	}
	
}