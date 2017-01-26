package com.jjambbongg.springmvcboard.dto;

import java.sql.Timestamp;

public class BoardDTO {

	private int seq;
	private String id;
	private String title;
	private String content;
	private Timestamp date;
	
	public BoardDTO() {
		
	}
	
	public BoardDTO(int seq, String id, String title, String content, Timestamp date) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
