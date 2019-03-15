package com.su.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.model.Flower;
import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	private FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String desc=req.getParameter("desc");
		Flower flower=new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setDesc(desc);
		int index=flowerService.add(flower);
		if(index>0) {
			resp.sendRedirect("show");
		}else {
			resp.sendRedirect("add.jsp");
		}
	}
}
