package com.jjambbongg.springmvcboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.jjambbongg.springmvcboard.dto.BoardDTO;
import com.jjambbongg.springmvcboard.util.ConstantJDBC;

public class BoardDAO {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		template = ConstantJDBC.template;
	}
	
	public ArrayList<BoardDTO> list() {
		String query = "SELECT seq, id, title, content, date FROM board ORDER BY seq DESC";
		return (ArrayList<BoardDTO>) template.query(query, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}

	public BoardDTO view(String seq) {
		String query = "SELECT seq, id, title, content FROM board WHERE seq =" + seq;
		return (BoardDTO) template.queryForObject(query, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	public void write(final String id, final String title, final String content) {
		template.update(new PreparedStatementCreator() {
			String query = "INSERT INTO board(id, title, content, date) VALUES(?, ?, ?, ?)";
			long currentTime = Calendar.getInstance().getTimeInMillis();	
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				pstmt.setTimestamp(4, new Timestamp(currentTime));
				return pstmt;
			}
		});
	}
	
	public void delete(final String seq) {
		String query = "DELETE FROM board WHERE seq = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				int seqInt = 0;
				if(seq!=null && !seq.isEmpty()) {
					seqInt = Integer.parseInt(seq);
				}	
				pstmt.setInt(1, seqInt);
			}
		});
	}
	
	public void modify(final String seq, final String id, final String title, final String content) {
		template.update(new PreparedStatementCreator() {
			String query = "UPDATE board SET id=?, title=?, content=? WHERE seq=?";
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				int seqInt = 0;
				if(seq!=null && !seq.isEmpty()) {
					seqInt = Integer.parseInt(seq);
				}		
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				pstmt.setInt(4, seqInt);
				return pstmt;
			}
		});
	}
	
}
