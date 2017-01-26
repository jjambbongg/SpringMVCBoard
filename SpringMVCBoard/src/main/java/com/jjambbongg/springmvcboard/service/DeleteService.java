package com.jjambbongg.springmvcboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jjambbongg.springmvcboard.dao.BoardDAO;

public class DeleteService implements BoardService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		dao.delete(seq);
	}

}
