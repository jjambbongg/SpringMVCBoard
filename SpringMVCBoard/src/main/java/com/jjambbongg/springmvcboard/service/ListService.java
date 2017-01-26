package com.jjambbongg.springmvcboard.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.jjambbongg.springmvcboard.dao.BoardDAO;
import com.jjambbongg.springmvcboard.dto.BoardDTO;

public class ListService implements BoardService{

	@Override
	public void execute(Model model) {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		model.addAttribute("list", list);
	}

}
