package com.linzi.shop.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ValidateUtil {
	public static boolean validateNull(HttpServletRequest requst, String[] fields) {
		boolean validate = true;
		Map<String, String> errorMsg = new HashMap<String, String>();
		for (String field: fields){
			String value = requst.getParameter(field);
			if (value == null || "".equals(value.trim())){
				validate = false;
				errorMsg.put(field, field+"不能为空");
			}
		}
		if (!validate) {
			requst.setAttribute("errorMsg", errorMsg);
		}
		return validate;
	}
	
	@SuppressWarnings("unchecked")
	public static String showError(HttpServletRequest request, String field){
		Map<String, String> errorMsg = (Map<String, String>)request.getAttribute("errorMsg");
		if (errorMsg == null) 
			return "";
		String msg = errorMsg.get(field);
		if (msg == null)
			return "";
		return msg;
	}
}
