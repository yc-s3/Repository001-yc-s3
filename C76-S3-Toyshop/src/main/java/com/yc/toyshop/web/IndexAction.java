package com.yc.toyshop.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yc.toyshop.bean.User;
import com.yc.toyshop.biz.BizException;
import com.yc.toyshop.biz.UserBiz;
import com.yc.toyshop.dao.UserMapper;
import com.yc.toyshop.vo.Result;

@Controller
public class IndexAction {
	@Resource
	private UserBiz ubiz;

	@Resource
	private UserMapper um;
	
	/**
	 * 首页
	 * @return
	 */
	@GetMapping({ "/", "toindex", "index.html" })
	public String toreg() {
		return "index";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@GetMapping("tologin")
	public String tologin() {
		return "login";
	}
	@PostMapping("login")
	@ResponseBody
	public Result login(@Valid User user, Errors errors, HttpSession session) {
		if (errors.hasFieldErrors("loginname") || errors.hasFieldErrors("password")) {
			return new Result(1, "请输入用户名和密码");
		}
	
		try {
			User dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			
			return new Result(0, "登入成功", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getCode(), e.getMessage());
		}
	} 
	/**
	 * 注册
	 * @return
	 */
	@GetMapping("toregister")
	public String toregister() {
		return "register";
	}
	
	/**
	 * 购物
	 * @return
	 */
	@GetMapping("toshop")
	public String toshop() {
		return "shop";
	}
	
	
	/**
	 * 关于
	 * @return
	 */
	@GetMapping("toabout")
	public String toabout() {
		return "about";
	}
	
	/**
	 * 错误页面
	 * @return
	 */
	@GetMapping("toerror")
	public String toerror() {
		return "error";
	}
	
	/**
	 * 购物车
	 * @return
	 */
	@GetMapping("tocheckout")
	public String tocheckout() {
		return "checkout";
	}
	
}
