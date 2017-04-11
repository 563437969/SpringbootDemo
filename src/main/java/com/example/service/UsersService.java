package com.example.service;

import java.util.List;

import com.example.entity.Users;
import com.example.entity.base.DataTable;

public interface UsersService {
	
	/**
	 * 添加用户
	 * */
	public Users insertUser(Users user);
	
	/**
	 * 更新用户
	 * */
	public boolean updateUser(Users user);
	
	/**
	 * 删除用户
	 * */
	public boolean deleteUser(Users user);
	
	/**
	 * 用户分页
	 * */
	public DataTable<Users> getUserPageList(Users user);
	
	/**
	 * 获取用户信息（缓存）
	 * */
	public Users getCacheUserById(Users user);
	
	/**
	 * 获取所有用户列表  （测试redis缓存）
	 * */
	public List<Users> getCacheUserList();
	
	/**
	 * 用户登录
	 * */
	public Users loginUser(Users user);
	
}
