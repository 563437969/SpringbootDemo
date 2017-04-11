package com.example.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json操作工具类
 * @author jxq
 */
public class JsonUtil<T> {
	
public static final String WRITEERRORMSGJSON = "{\"success\":0,\"msg\":\"json生成失败\"}";
	
	public static final String READERRORMSGJSON = "{\"success\":0,\"msg\":\"json解析失败\"}";
	
	private ObjectMapper mapper = null;
	
	private Map<String,Object> map = null;
	
	/**
	 * 解析json数据
	 * */
	public T readJson(String json,Class<T> classRes) throws Exception
	{
		if(null == mapper){
			mapper = new ObjectMapper(); 
		}
		T objClass = null;
		try {
			objClass = mapper.readValue(json,classRes);
		} catch (Exception e) {
			throw e;
		}
		return objClass;
	}
	
	
	/**
	 * 生成json数据
	 * */
	public String writeJson(Object obj)
	{
		String json = "";
		
		if(null == mapper){
			mapper = new ObjectMapper(); 
		}
		
		map = new HashMap<String, Object>();
		
		map.put("data", obj);
		map.put("success", "1");
		try {
			json = mapper.writeValueAsString(map);
		} catch (Exception e) {
			json = WRITEERRORMSGJSON;
		}
		return json;
	}
}
