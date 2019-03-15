package com.su.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.su.model.User;

@Controller
public class UserController {
	@RequestMapping("/userlist")
	public String showUser(Model model) {
		List<User> list = new ArrayList<>(); 
		list.add(new User(1,"张三",18));
		list.add(new User(2,"李四",23));
		list.add(new User(3,"王五",48));
		model.addAttribute("list",list);
		return "showUser";
	}
}
