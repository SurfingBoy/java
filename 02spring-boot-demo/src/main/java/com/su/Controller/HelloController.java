package com.su.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Value("${hello}")
	private String hello;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String show() {
		return this.hello;
	}
}
