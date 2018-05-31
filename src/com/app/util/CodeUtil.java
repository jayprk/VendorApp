package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	
	private static String getCommonsStr(int len){
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0,len);
	}
	
	public static String genPwd(){
		return getCommonsStr(6);
	}
	public static String genToken(){
		return getCommonsStr(8);
	}
}
