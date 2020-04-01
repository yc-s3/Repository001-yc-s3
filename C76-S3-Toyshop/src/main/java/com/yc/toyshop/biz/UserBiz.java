package com.yc.toyshop.biz;

import java.util.List;


import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.toyshop.bean.User;
import com.yc.toyshop.bean.UserExample;
import com.yc.toyshop.dao.UserMapper;


@Service
public class UserBiz {
	
	
	@Resource
	private UserMapper um;

	
	public User login(@Valid User user) throws BizException {
		UserExample ue=new UserExample();
		ue.or().andLoginnameEqualTo(user.getLoginname()).andPasswordEqualTo(user.getPassword());
		ue.or().andUsernameEqualTo(user.getLoginname()).andPasswordEqualTo(user.getPassword());
		ue.or().andEmailEqualTo(user.getLoginname()).andPasswordEqualTo(user.getPassword());
		
		List<User> list=um.selectByExample(ue);
	
		if(list.size()==0) {
			throw new BizException(103,"name","用户名或密码错误");
		}else if(list.size()>1) {
			throw new BizException(104,"name","存在多个相同 的账号信息,请跟换其他登入字段");
		}else {
			return list.get(0);
		}
	}
	

	
}
