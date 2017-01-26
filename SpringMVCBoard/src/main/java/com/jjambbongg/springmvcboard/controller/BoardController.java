package com.jjambbongg.springmvcboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjambbongg.springmvcboard.service.BoardService;
import com.jjambbongg.springmvcboard.service.DeleteService;
import com.jjambbongg.springmvcboard.service.ListService;
import com.jjambbongg.springmvcboard.service.ModifyService;
import com.jjambbongg.springmvcboard.service.ViewService;
import com.jjambbongg.springmvcboard.service.WriteService;
import com.jjambbongg.springmvcboard.util.ConstantJDBC;

@Controller
public class BoardController {

	BoardService service;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		ConstantJDBC.template = this.template;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		service = new ListService();
		service.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "write_view";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new WriteService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new ViewService();
		service.execute(model);
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new DeleteService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new ModifyService(); 
		service.execute(model);
		return "redirect:list";
	}
	
	private void printLog(StackTraceElement[] stacktrace) {
		//StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[1];
		String methodName = e.getMethodName();
		System.out.println(methodName);
	}
}
