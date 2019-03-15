package com.su.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> show(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("msg","Hello World");
		return map;
	}
}
