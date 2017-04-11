package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.entity.Users;

public interface UsersDao {

	@Insert("INSERT INTO users(userName,password,nickName,phone,email,status) "
			   + "VALUES(#{userName},#{password},#{nickName},#{phone},#{email},#{status})")
    int insertUser(Users user);
	
	@Update("UPDATE users SET userName=#{userName},nickName=#{nickName},password=#{password},phone=#{phone},email=#{email},status=#{status} WHERE id=#{id}")
	int updateUser(Users user);
	
	@Delete("DELETE FROM users WHERE id=#{id}")
	int daleteUser(Users user);
	
	List<Users> getUserPageList(Users user);
	
	int getUserPageListTotal(Users user);
	
	//获取用户信息
	Users getCacheByUser(Users user);
	
	//测试redis Cacheable
	@Select("SELECT id,userName,password,nickName,phone,email,status FROM users")
	List<Users> getCacheUserList();
	
}
