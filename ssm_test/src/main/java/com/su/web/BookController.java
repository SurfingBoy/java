package com.su.web;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.su.dto.AppointExecution;
import com.su.dto.Result;
import com.su.entity.Book;
import com.su.enums.AppointStateEnum;
import com.su.exception.NoNumberException;
import com.su.exception.RepeatAppointException;
import com.su.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 查询所有图书
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item",method=RequestMethod.GET)
	private String item(Model model) {
		List<Book> list=bookService.getList();
		model.addAttribute("list",list);
		return "list";
	}
	
	/**
	 * 一本图书
	 * @param bookId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{bookId}/detail",method=RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId,Model model) {
		if(bookId==null) {
			return "redirect:/book/item";
		}
		
		Book book=bookService.getById(bookId);
		if(book==null) {
			return "forward:/book/item";
		}
		model.addAttribute("book",book);
		return "detail";
	}
	
	@RequestMapping(value="/{bookId}/appoint",method=RequestMethod.POST,produces= {"application/json;charset=utf-8"})
	@ResponseBody
	//produces设置返回数据的类型以及编码，但必须和@ResponseBody注解一起使用
	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId,@RequestParam("studentId") Long studentId){
		if(studentId == null || studentId.equals("")) {
			return new Result<>(false, "学号不能为空");
		}
		AppointExecution execution=null;
		try {
			execution=bookService.appoint(bookId, studentId);
		} catch (NoNumberException e1) {
			// TODO Auto-generated catch block
			execution=new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			// TODO: handle exception
			execution=new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			// TODO: handle exception
			execution=new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}
}
