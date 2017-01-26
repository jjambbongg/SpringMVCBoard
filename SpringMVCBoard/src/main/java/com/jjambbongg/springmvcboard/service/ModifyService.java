package com.jjambbongg.springmvcboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jjambbongg.springmvcboard.dao.BoardDAO;
import com.jjambbongg.springmvcboard.dto.BoardDTO;

public class ModifyService implements BoardService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int seqInt = 0;
		String seq = request.getParameter("seq");
		if(seq!=null && !seq.isEmpty()) {
			seqInt = Integer.parseInt(seq);
		}
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.modify(seq, id, title, content);
	}

}
