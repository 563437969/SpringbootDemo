package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Users;
import com.example.service.UsersService;

/**
 * 2017-03-29 jxq
 * 主页面
 * */
@Controller
public class IndexController {
	
	@Resource
	private UsersService usersService;
	
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource
	private RedisTemplate<String,Users> redisTemplate;
	
	private int index =  1;
	
	@RequestMapping(value="/")
	public String main(HttpServletRequest request){
		//forward:aaaa  redirect:aaaa
//		stringRedisTemplate.opsForValue().set("stringRedisTemplate","stringRedisTemplate测试");
//		
//		Users user = new Users();
//		user.setId("1");
//		user.setNickName("缓存"+index++);
//		user.setUserName("ceshi"+index);
//		user.setEmail("46574987@qq.com");
//		user.setPhone("1354687898"+index);
//		user.setStatus("1");
//		
//		
//		redisTemplate.opsForValue().set("redisTemplate", user);
		
		return "index";
	}
	
	@RequestMapping(value="/getCache")
	@ResponseBody
	public Users getCache(HttpServletRequest request){
		//forward:aaaa  redirect:aaaa
		Users userTmp = new Users();
		userTmp.setId("2");
		System.out.println("测试缓存BEGIN");
		Users user = usersService.getCacheUserById(userTmp);
		usersService.getCacheUserList();
		System.out.println("测试缓存END");
		
		return user;
	}
	
	@RequestMapping(value="/updateCache")
	@ResponseBody
	public Users updateCache(HttpServletRequest request){
		//forward:aaaa  redirect:aaaa
		
		System.out.println("更新缓存BEGIN");
		Users user = new Users();
		user.setId("1");
		user.setNickName("缓存"+index++);
		user.setUserName("ceshi"+index);
		user.setEmail("46574987@qq.com");
		user.setPhone("1354687898"+index);
		user.setStatus("1");
		if( usersService.updateUser(user)){
			System.out.println("更新缓存END");
		}
		
		return user;
	}
	
	@RequestMapping(value="/deleteCache")
	@ResponseBody
	public Users deleteCache(HttpServletRequest request){
		//forward:aaaa  redirect:aaaa
		
		System.out.println("删除缓存BEGIN");
		Users user = new Users();
		user.setId("1");
		if(usersService.deleteUser(user)){
			System.out.println("更新缓存END");
		}
		return user;
	}

}
