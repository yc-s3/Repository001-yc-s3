package com.yc.toyshop.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yc.toyshop.bean.User;
import com.yc.toyshop.mapper.UserMapper;

@Service
public class UserBiz {
	
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 	登录方法
	 * @param id
	 * @return
	 */
	public User login(Integer id){
		return this.userMapper.selectByPrimaryKey(id);

	}
	
	/**
	 * 注册方法
	 * @param user
	 * @param repwd
	 */
	public void reg(User user){
	
		userMapper.insert(user);
	}
	

}
