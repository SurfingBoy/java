package com.su.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.model.Flower;
import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;

@WebServlet("/show")
public class ShowServlet  extends HttpServlet{
	private FlowerService flowerService=new FlowerServiceImpl();
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		List<Flower> list=flowerService.show();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
