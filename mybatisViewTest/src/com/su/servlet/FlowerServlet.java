package com.su.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.model.Flower;
import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;

@WebServlet("/insert")
public class FlowerServlet extends HttpServlet{
	private FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Flower flower=new Flower();
		flower.setName(request.getParameter("name"));
		flower.setPrice(Double.parseDouble(request.getParameter("price")));;
		flower.setDesc(request.getParameter("desc"));
		int index=flowerService.ins(flower);
		if(index>0) {
			System.out.print("成功");
		}else {
			System.out.print("失败");
		}
	}
}
