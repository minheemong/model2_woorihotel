package com.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hotel.dto.AdminDto;
import com.hotel.dto.MemberDto;
import com.hotel.dto.QnaDto;
import com.hotel.dto.bookDto;
import com.hotel.utill.Dbman;
import com.hotel.utill.Paging;



public class AdminDao {
	private AdminDao() {}
	private static AdminDao instance = new AdminDao();
	public static AdminDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminDto workerCheck(String workId) {
		AdminDto adto = null;
		String sql = "select * from worker where id=?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				adto = new AdminDto();
				adto.setId( rs.getString("id") );
				adto.setPwd( rs.getString("pwd") );
				adto.setName( rs.getString("name") );
				adto.setPhone( rs.getString("phone") );
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}	
		return adto;
	}
	public int getAllCount(String tableName, String fieldName1, String fieldName2, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tableName +" where " +fieldName1+
				" like '%'||?||'%' and "+fieldName2+ " like '%'||?||'%' ";
		// 필듭명 like '%'||?||'%'" 에서? 가 빈칸이거나 널이면 ,해당필드의 조건은 검색하지않는것과 같아집니다.
		try {
			  con = Dbman.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  pstmt.setString(2, key);
			  rs = pstmt.executeQuery();
			  if(rs.next()) count = rs.getInt("cnt");
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); } 
		return count;
	}

  



	public int getAllCount(String tableName, String fieldName, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tableName +" where "+fieldName+
				" like '%'||?||'%' ";
		// 필듭명 like '%'||?||'%'" 에서? 가 빈칸이거나 널이면 ,해당필드의 조건은 검색하지않는것과 같아집니다.
		try {
			  con = Dbman.getConnection();
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  rs = pstmt.executeQuery();
			  if(rs.next()) count = rs.getInt("cnt");
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); } 
		return count;
	}


	





	public int getAllCount(String key) {
		int count = 0;
		String sql = "select count(*) as cnt from qna where id like '%'||?||'%' or content like '%'||?||'%'";
				
		 con = Dbman.getConnection();
		try {
			 
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  pstmt.setString(2, key);
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) count = rs.getInt("cnt");
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); } 
		return count;
	}

	public int getAllCountmember(String key) {
		int count = 0;
		String sql = "select count(*) as cnt from qna where id like '%'||?||'%' or content like '%'||?||'%'";
				
		 con = Dbman.getConnection();
		try {
			 
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, key);
			  pstmt.setString(2, key);
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) count = rs.getInt("cnt");
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); } 
		return count;
	}

	public ArrayList<QnaDto> listQna(Paging paging, String key) {
	
		 ArrayList<QnaDto> list= new ArrayList<QnaDto>();
			String sql =  /* "select *from qna order by qnaseq"; */
				 
				 
		 "select * from ("
			+ "select * from ("
			+ "select rownum as rn, o.* from "
			+ "((select * from qna where id like '%'||?||'%' "
			+ "order by qnaseq desc) o)"
			+ " ) where rn >=?"
			+ " ) where rn <=?";
	
		con=Dbman.getConnection();
		try {
			
			  pstmt=con.prepareStatement(sql); 
				
				  pstmt.setString(1, key);
				 
				  pstmt.setInt(2,paging.getStartNum());
				  pstmt.setInt(3, paging.getEndNum());
				
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
			}catch (Exception e) { e.printStackTrace();
		    } finally { Dbman.close(con, pstmt, rs); } 
			
		
		return list;
	}


	public void updateQna(QnaDto qdto) {
		String sql = "update qna set reply=?, rep='2' where qnaseq=?";
		con = Dbman.getConnection();
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, qdto.getReply());
			pstmt.setInt(2, qdto.getQnaseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}


	public ArrayList<MemberDto> listmember(Paging paging, String key) {
		 ArrayList<MemberDto> list= new ArrayList<>();
		 String sql = "select * from ("
					+ "select * from ("
					+ "select rownum as rn, o.* from "
					+ "((select * from hotelmember where id like '%'||?||'%'  or name like '%'||?||'%' "   
					+ ") o)"
					+ " ) where rn >=?"
					+ " ) where rn <=?";
		
		 con = Dbman.getConnection();
		 try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, key);
				pstmt.setString(2, key); 
				pstmt.setInt(3, paging.getStartNum());
				pstmt.setInt(4, paging.getEndNum());
				rs = pstmt.executeQuery();
			while(rs.next()) {
			MemberDto	mto = new MemberDto();
		    	mto.setId(rs.getString("id"));
		    	mto.setPwd(rs.getString("pwd"));
		    	mto.setName(rs.getString("name"));
		    	mto.setEmail(rs.getString("email"));
		    	mto.setZip_num(rs.getString("zip_num"));
		    	mto.setAddress(rs.getString("address"));
		    	mto.setPhone(rs.getString("phone"));
		    	list.add(mto);
		    	 
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Dbman.close(con, pstmt, rs);
			}
			
		return list;
	}


  }


