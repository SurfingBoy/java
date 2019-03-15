package com.su.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class DemoController {
	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse response,
			HttpServletRequest request) throws IOException{ 
		//设置响应流进行文件下载
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//把二进制流放进响应体中
		ServletOutputStream outputStream=response.getOutputStream();
		//下载文件路径
		String pathString=request.getServletContext().getRealPath("files");
		System.out.print(pathString);
		File file=new File(pathString, fileName);
		byte[] bytes=FileUtils.readFileToByteArray(file);
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name) throws IOException{
		System.out.print(name);
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("d:/"+uuid+suffix));
		return "/success.jsp";
	}
}
