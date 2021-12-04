package com.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.hotel.dto.QnaDto;
import com.hotel.utill.Dbman;



public class QnaDao {
	private QnaDao() { }
	private static QnaDao ist = new QnaDao();
	public static QnaDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaDto> listQna(String id) {
		
		ArrayList<QnaDto> list = new ArrayList<QnaDto>();
		String sql = "select *from qna where id=? order by qnaseq desc"; 
				
				/*
				 * "select rownum as rn , t.* from" +
				 * " (select * from qna order by qnaseq asc)t " +
				 * "where id = ? order by rn desc";
				 */
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaDto qdto = new QnaDto();
				qdto.setQnaseq(rs.getInt("qnaseq"));
				qdto.setTitle(rs.getString("title"));
				qdto.setContent(rs.getString("content"));
				qdto.setId(rs.getString("id"));
				qdto.setIndate(rs.getTimestamp("indate"));
				qdto.setReply(rs.getString("reply"));
				qdto.setRep(rs.getString("rep"));		    	
		    	list.add(qdto);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}
	
	
	public void insertQna(QnaDto qdto) {
		String sql = "insert into qna(qnaseq,title,content,id) "
				+ "values(seq_qna_qnaseq.nextval, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qdto.getTitle());
		    pstmt.setString(2, qdto.getContent());
		    pstmt.setString(3, qdto.getId());
		    
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
	
}
	public QnaDto getQna(int qnaseq) {
		QnaDto qdto = new QnaDto();
		String sql = "select * from qna where qnaseq =?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,qnaseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qdto.setQnaseq(qnaseq);
				qdto.setTitle(rs.getString("title"));
				qdto.setContent(rs.getString("content"));
				qdto.setId(rs.getString("id"));
				qdto.setIndate(rs.getTimestamp("indate"));
				qdto.setReply(rs.getString("reply"));
				qdto.setRep(rs.getString("rep"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return qdto;
	}


	


	public void deleteQna(Integer qnaseq) {
		String sql = "delete from qna where qnaseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qnaseq);
			pstmt.executeUpdate();
			
			// 댓글 삭제 추가
			//	pstmt.close();
			
			
			//  sql = "delete from reply where qnaseq = ?"; pstmt =
			//  con.prepareStatement(sql); pstmt.setInt(1, qnaseq); pstmt.executeUpdate();
			 
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }	
		
	}


	public void updateQna(QnaDto qdto) {
String sql = "update qna set title=?, content=?"  
				+ " where qnaseq=?";
System.out.println(1);
		con=Dbman.getConnection();
		System.out.println(2);
		try {
			System.out.println(3);
		pstmt = con.prepareStatement(sql);
		
								System.out.println(4);
		pstmt.setString(1, qdto.getTitle());
									System.out.println(5);
		 pstmt.setString(2, qdto.getContent());
		
		pstmt.setInt(3, qdto.getQnaseq());
								System.out.println(12);
	    pstmt.executeUpdate();  
	    						System.out.println(13);
	} catch (SQLException e) {e.printStackTrace();
	} finally { Dbman.close(con, pstmt, rs);}


	}
	
	
}

	
	
	
	
	
	


