package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UsersDao;
import com.example.entity.Users;
import com.example.entity.base.DataTable;
import com.example.service.UsersService;
import com.example.service.base.ServiceException;
import com.example.util.Md5Util;

@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersDao usersDao;

	@Override
	public DataTable<Users> getUserPageList(Users user) {
		List<Users> list = usersDao.getUserPageList(user);
		int total = usersDao.getUserPageListTotal(user);
		return new DataTable<Users>(list, user.getPageDraw(), total);
	}

	@Override
	public Users insertUser(Users user) {
		
		user.setPassword(Md5Util.getPwd(user.getPassword()));
		Users userTmp = null;
		try{
			if(usersDao.insertUser(user) <= 0){
				throw new ServiceException("插入用户发生异常");
			}
			
			//获取用户信息
			userTmp = usersDao.getCacheByUser(user);
			
		}catch(Exception e){
			throw new ServiceException("插入用户发生异常");
		}
		
		return userTmp;
	}

	@Override
	@Cacheable(value = "userCache",key = "'user:'+#user.id")
	public Users getCacheUserById(Users user) {
		System.out.println("用户信息无缓存进入....");
		return usersDao.getCacheByUser(user);
	}
	
	@Override
	//@CachePut(value = "userCache",key = "'user:'+#user.id")
	@CacheEvict(value = "userCache",key = "'user:'+#user.id")
	public boolean updateUser(Users user) {
		if(usersDao.updateUser(user) > 0){
			return true;
		}
		return false;
	}
	
	@Override //allEntries=true 全部删除 
	@CacheEvict(value = "userCache",key = "'user:'+#user.id")
	public boolean deleteUser(Users user) {
		if(usersDao.daleteUser(user) > 0){
			return true;
		}
		return false;
	}
	
	@Override
	@Cacheable(value = "userListCache",keyGenerator = "wiselyKeyGenerator")
	public List<Users> getCacheUserList() {
		System.out.println("测试用户列表无缓存进入....");
		return usersDao.getCacheUserList();
	}

	@Override
	public Users loginUser(Users user) {
		user.setPassword(Md5Util.getPwd(user.getPassword()));
		return this.getCacheUserById(user);
	}

}
