package com.jjambbongg.springmvcboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jjambbongg.springmvcboard.dao.BoardDAO;

public class WriteService implements BoardService{

	@Override
	public void execute(Model model) {
	
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.write(id, title, content);
	}
}
