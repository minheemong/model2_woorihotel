package com.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hotel.dto.AddressDto;
import com.hotel.dto.MemberDto;
import com.hotel.utill.Dbman;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao ist = new MemberDao();
	public static MemberDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public MemberDto getMember(String id) {
		MemberDto mto = null;
		String sql = "select * from hotelmember where id = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	mto = new MemberDto();
		    	mto.setId(id);
		    	mto.setPwd(rs.getString("pwd"));
		    	mto.setName(rs.getString("name"));
		    	mto.setEmail(rs.getString("email"));
		    	mto.setZip_num(rs.getString("zip_num"));
		    	mto.setAddress(rs.getString("address"));
		    	mto.setPhone(rs.getString("phone"));
		      
		    } 
		} catch (SQLException e) { e.printStackTrace();
		} finally {	 Dbman.close(con, pstmt, rs);	}		
		return mto;
	}
	
	public void resetPw(MemberDto mvo) {
		con = Dbman.getConnection();
		String sql = "update hotelmember set pwd=? where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
	
	
	public MemberDto confirmIdnamePhone(String id, String name, String phone) {
		MemberDto mvo = null;
		String sql = "select * from hotelmember where name=? and phone=? and id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MemberDto();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return mvo;
	}
	
	
	public MemberDto confirmPhone(String name, String phone) {
		MemberDto mvo = null;
		String sql = "select * from hotelmember where name=? and phone=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MemberDto();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return mvo;
	}
	
	
	
	
	public void updateMember(MemberDto mvo) {
		String sql = "update hotelmember set pwd=?, name=?, zip_num=?, address=?," + " email=?, phone=? where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getZip_num());
			pstmt.setString(4, mvo.getAddress());
			pstmt.setString(5, mvo.getEmail());
			pstmt.setString(6, mvo.getPhone());
			pstmt.setString(7, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
	public void insertMember(MemberDto mvo) {
		String sql = "insert into hotelmember(id,pwd,name,zip_num,address,email,phone) " + "values(?,?,?,?,?,?,?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress());
			pstmt.setString(6, mvo.getEmail());
			pstmt.setString(7, mvo.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
	
	public ArrayList<AddressDto> selectAddressByDong(String dong) {
		ArrayList<AddressDto> list = new ArrayList<AddressDto>();
		String sql = "select * from address where dong like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressDto avo = new AddressDto();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
	
	
	
	public int confirmID(String id) {
		int result = -1;
		String sql = "select * from hotelmember where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = 1; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	
	
	

	public void deleteMember(String id) {
		con = Dbman.getConnection();
		String sql = "delete from hotelmember where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
