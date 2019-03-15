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
public class FlowerServlet extends HttpServlet{
	private FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Flower> list=flowerService.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
