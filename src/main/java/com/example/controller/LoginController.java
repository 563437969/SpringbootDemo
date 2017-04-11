package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.util.ConstantUtil;

@Controller
public class LoginController {
	
	@Resource
	private UsersService usersService;
	
	/**
	 * 用户登录
	 * */
	@RequestMapping(value="/loginUser")
	public String login(HttpServletRequest request,Map<String,Object> map){
		Object userId = request.getSession().getAttribute(ConstantUtil.USERID);
		if(null != userId && !"".equals(userId)){
			return "redirect:/";
		}
		map.put("title","用户登录");
		
		return "login";
	}
	
	/**
	 * 用户登录
	 * */
	@RequestMapping(value="/loginLogin")
	public String loginLogin(HttpServletRequest request,Map<String,Object> map,Users user){
		
		//登录
		Users userTmp = usersService.loginUser(user);
		if(null != userTmp){
			request.getSession().setAttribute(ConstantUtil.USERID,userTmp.getId());
			
			request.getSession().setAttribute(ConstantUtil.USERIDINFO,userTmp);
		}
		
		return "redirect:/";
	}
	
	/**
	 * 用户注册
	 * */
	@RequestMapping(value="/loginRegister")
	public String register(HttpServletRequest request,Map<String,Object> map,Users user){
		
		Users regUser = usersService.insertUser(user);
		System.out.println("注册");
		if(null == regUser){
			//TODO 错误处理
		}
		
		request.getSession().setAttribute(ConstantUtil.USERID,regUser.getId());
		
		request.getSession().setAttribute(ConstantUtil.USERIDINFO,regUser);
		return "redirect:/";
	}
	
	/**
	 * 注销
	 * */
	@RequestMapping(value="/loginLogout")
	public String logout(HttpServletRequest request){
		
		request.getSession().setAttribute(ConstantUtil.USERID,null);
		request.getSession().setAttribute(ConstantUtil.USERIDINFO,null);
		
		return "redirect:/";
	}

}
