package com.su.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateUserStatement.UserSpecification;
import com.su.model.Users;
import com.su.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page,Users users) {
		return page;
	}
	
	/**
	 * 添加用户
	 * @param users
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(@Valid  Users users,BindingResult result) {
		if(result.hasErrors()) {
			return "input";
		}
		this.userService.addUser(users);
		return "redirect:/users/findUserAll";
	}
	
	@RequestMapping("/findUserAll")
	@Cacheable(value="zidingyi")//value值为ehcache自定义的缓存name值，如果不指定则为默认值
	public String findUsersAll(Model model) {
		List<Users> list=this.userService.findUsersAll();
		model.addAttribute("list",list);
		return "showUsers";
	}
	
	@RequestMapping("/findUserById")
	@CacheEvict(value="zidingyi",allEntries=true)//清除缓存
	public String findUserById(int id,Model model) {
		Users users=this.userService.findUserById(id);
		model.addAttribute("user",users);
		return "updateUser";
	}
	
	@RequestMapping("/editUser")
	public String editUser(Users users) {
		this.userService.updateUser(users);
		return "redirect:/users/findUserAll";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(int id) {
		this.userService.deleteUser(id);
		return "redirect:/users/findUserAll";
	}
}
