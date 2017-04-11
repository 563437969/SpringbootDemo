package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Users;
import com.example.entity.base.DataTable;
import com.example.service.UsersService;

@Controller
@RequestMapping(value="/users")
public class UsersController {
	
	
	@Resource
	private UsersService usersService;
	
	/**
	 * 用户列表页
	 * */
	@RequestMapping(value="/list")
	public String getList(){
		return "list";
	}
	
	/**
	 * 获取用户列表
	 * */
	@RequestMapping(value="/getList")
	@ResponseBody
	public DataTable<Users> ajaxList(HttpServletRequest request){
		
		System.out.println("=====start:====="+request.getParameter("start"));
		System.out.println("=====length:====="+request.getParameter("length"));
		System.out.println("=====draw:====="+request.getParameter("draw"));
		System.out.println("=====search[value]:====="+request.getParameter("search[value]"));
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		String search = request.getParameter("search[value]");
		
		Users user = new Users();
		user.setPageStart(start == null ? 0 : Integer.parseInt(start));
		user.setPageLength(length == null ? 0 : Integer.parseInt(length));
		user.setPageDraw(draw == null ? 0 : Integer.parseInt(draw));
		user.setPageSearch(search);
		
		DataTable<Users> dataTable =  usersService.getUserPageList(user);
		
		return dataTable;
	}

}
