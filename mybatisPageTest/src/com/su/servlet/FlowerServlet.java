package com.su.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.model.PageInfo;
import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;

@WebServlet("/page")
public class FlowerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FlowerService flowerService=new FlowerServiceImpl();
		int pagenum=1;
		int pagesize=2;
		String pagenumStr=req.getParameter("pagenum");
		String pagesizeStr=req.getParameter("pagesize");
		String name=req.getParameter("name");       
		System.out.print(name);
		if(pagenumStr!=null && !pagenumStr.equals("")) {
			pagenum=Integer.parseInt(pagenumStr);
		}
		if(pagesizeStr!=null && !pagesizeStr.equals("")) {
			pagesize=Integer.parseInt(pagesizeStr);
		}
		if(name!=null && !name.equals("")) {
			name=new String(name.getBytes("iso8859-1"),"utf-8");
		}
		String pString=req.getParameter("price");
		double price=0;
		if(pString!=null && !pString.equals("")) {
			price=Double.parseDouble(pString);
		}
		
		
		PageInfo pInfo=flowerService.show(pagenum, pagesize,name,price);
		
		req.setAttribute("pageInfo", pInfo);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
