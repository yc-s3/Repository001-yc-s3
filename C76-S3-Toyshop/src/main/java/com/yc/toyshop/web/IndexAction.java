package com.yc.toyshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAction {

	
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
