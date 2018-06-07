package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	public Object jsonToObj(String json,Class<?> clz){
		Object ob=null;
		try {
			ob= new ObjectMapper().readValue(json, clz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob; 
	}
	
	public String objToJson(Object ob){
		String json=null;
		try {
			json=new ObjectMapper().writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json; 
	}
}
