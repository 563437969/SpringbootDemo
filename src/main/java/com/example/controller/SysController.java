package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/sys")
public class SysController {
	
	/**
	 * 设置
	 * */
	@RequestMapping(value="/seting")
	public String getList(Map<String,Object> map){
		return "seting";
	}

}
