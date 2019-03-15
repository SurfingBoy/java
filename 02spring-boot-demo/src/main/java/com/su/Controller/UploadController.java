package com.su.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController //相当于@Controller+@ResponseBody 将该类的方法返回值自动转换为json格式
public class UploadController {
	@RequestMapping("/upload")
	public String fileUpload(MultipartFile filename) throws IllegalStateException, IOException {
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("d:/"+filename.getOriginalFilename()));
		return "OK";
	}
}
