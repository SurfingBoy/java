package com.su.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;

@WebServlet("/flower")
public class FlowerServlet extends HttpServlet{
	private FlowerService flowerService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ApplicationContext aContext=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		flowerService=aContext.getBean("flowerService",FlowerServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("list", flowerService.show());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
