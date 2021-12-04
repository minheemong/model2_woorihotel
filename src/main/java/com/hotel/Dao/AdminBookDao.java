package com.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hotel.dto.bookDto;
import com.hotel.utill.Dbman;
import com.hotel.utill.Paging;

public class AdminBookDao {
	private AdminBookDao () {}
	private static AdminBookDao ist = new AdminBookDao();
	public static AdminBookDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int getAllCount(Paging paging, String id, String booknums, String indate, String outdate) {
		int count = 0;
		/* String sql = "select count(*) as cnt from book"; */
		String sql = "";
		
		con=Dbman.getConnection();
		try {
			if(booknums=="" && indate=="" && outdate=="" && id=="") {
				sql="select count(*) as cnt from book";
				pstmt=con.prepareStatement(sql);
			} else if(booknums=="" && indate=="" && outdate=="" && id!="") {
				sql="select count(*) as cnt from ( select rownum as rn, b.* from"
						+ " ( ( select * from book_view where id=?"
						+ " order by booknum desc) b )"
						+ ")";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
			} else if(id=="" && booknums!="" && indate=="" && outdate=="") {
				sql="select count(*) as cnt from ( select rownum as rn, b.* from"
						+ " ( ( select * from book_view where booknum=?"
						+ " order by booknum desc) b )"
						+ ")";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, booknums);
			} else if((id=="" && booknums=="" && indate!="") || (id=="" && booknums==""&&outdate!="")){
				if(indate!="" && outdate!="") {
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkin, 'YYYYMMDD')=? "
							+ " and to_char(checkout, 'YYYYMMDD')=?"
							+ " order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, indate);
					pstmt.setString(2, outdate);
				} else if(indate=="" && outdate!=""){
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkout, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, outdate);
				} else if(indate!="" && outdate=="") {
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkin, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, indate);
				}
			} else if((booknums=="" && id!="" && indate!="")||(booknums=="" && id!="" && outdate!="")) {
				if(indate!="" && outdate!="") {
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setString(3, outdate);
				} else if(indate=="" && outdate!=""){
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, outdate);
				} else if(indate!="" && outdate=="") {
					sql="select count(*) as cnt from ( select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " )";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
				}
			
			
			}rs = pstmt.executeQuery();
			if(rs.next()) count=rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}


	public ArrayList<bookDto> getbooklist(String id, Paging paging, String booknums, String indate, String outdate) {
		ArrayList<bookDto> list = new ArrayList<bookDto>();
		String sql = "";
		System.out.println();
		con=Dbman.getConnection();
		try {
			if(booknums=="" && indate=="" && outdate=="" && id=="") {
				System.out.println("전부 공백");
				sql="select * from("
						+ " select * from ("
						+ " select rownum as rn, b.* from"
						+ " ( ( select * from book_view order by result asc ,booknum desc ) b )"
						+ ") where rn>=?"
						+ ") where rn<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, paging.getStartNum());
				pstmt.setInt(2, paging.getEndNum());
			} else if(booknums=="" && indate=="" && outdate=="" && id!="") {
				System.out.println("아이디만 입력");
				sql="select * from("
						+ " select * from ("
						+ " select rownum as rn, b.* from"
						+ " ( ( select * from book_view where id=?"
						+ " order by result asc ,booknum desc) b )"
						+ ") where rn>=?"
						+ ") where rn<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			} else if(id=="" && booknums!="" && indate=="" && outdate=="") {
				System.out.println("번호만 입력");
				sql="select * from("
						+ " select * from ("
						+ " select rownum as rn, b.* from"
						+ " ( ( select * from book_view where booknum=?"
						+ " order by result asc ,booknum desc) b )"
						+ ") where rn>=?"
						+ ") where rn<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, booknums);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			} else if((id=="" && booknums=="" && indate!="") || 
					(id=="" && booknums=="" &&outdate!="")) {
				if(indate!="" && outdate!="") {
					System.out.println("체크인 체크아웃 날짜만 입력");
					System.out.println("아이디 : "+id);
					System.out.println("번호 : "+booknums);
					System.out.println("체크아웃 : "+outdate);
					System.out.println("체크인 : "+indate);
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkin, 'YYYYMMDD')=? "
							+ " and to_char(checkout, 'YYYYMMDD')=?"
							+ " order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, indate);
					pstmt.setString(2, outdate);
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
				} else if(indate=="" && outdate!=""){
					System.out.println("체크아웃 날짜만 입력");
					System.out.println("아이디 : "+id);
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkout, 'YYYYMMDD')=? "
							+ " order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, outdate);
					pstmt.setInt(2, paging.getStartNum());
					pstmt.setInt(3, paging.getEndNum());
				} else if(indate!="" && outdate=="") {
					System.out.println("체크인 날짜만 입력");
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where "
							+ " to_char(checkin, 'YYYYMMDD')=? "
							+ " order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, indate);
					pstmt.setInt(2, paging.getStartNum());
					pstmt.setInt(3, paging.getEndNum());
				}
			} else if(booknums=="" && id!="" && indate!="" || outdate!="") {
				if(indate!="" && outdate!="") {
					System.out.println("아이디, 체크인, 체크아웃 입력");
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setString(3, outdate);
					pstmt.setInt(4, paging.getStartNum());
					pstmt.setInt(5, paging.getEndNum());
				} else if(indate=="" && outdate!=""){
					System.out.println("아이디, 체크아웃 입력");
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? "
							+ " order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, outdate);
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
				} else if(indate!="" && outdate=="") {
					System.out.println("아이디, 체크인 입력");
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ " order by result asc ,booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
				}
			
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookDto bdto = new bookDto();
				bdto.setBdseq(rs.getInt("bdseq"));
				bdto.setBooknum(rs.getInt("booknum"));
				Timestamp checkin = rs.getTimestamp("checkin");
				Timestamp checkout = rs.getTimestamp("checkout");
				bdto.setCheckin(rs.getTimestamp("checkin"));
				bdto.setCheckout(rs.getTimestamp("checkout"));
				bdto.setId(rs.getString("id"));
				bdto.setKind(rs.getString("kind"));
				bdto.setName(rs.getString("name"));
				int oneday = rs.getInt("price");
				bdto.setPrice(days(oneday, checkin, checkout));
				/* bdto.setPrice(rs.getInt("price")); */
				bdto.setResult(rs.getString("result"));
				bdto.setUsernum(rs.getInt("usernum"));
				bdto.setHotelnum(rs.getInt("hotelnum"));
				list.add(bdto);
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}


	private int days(int oneday, Timestamp checkin, Timestamp checkout) {
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		System.out.println(sdf.format(checkin));
		System.out.println(sdf.format(checkout));
		String indayS = sdf.format(checkin);
		String outdayS = sdf.format(checkout);
		int inday = Integer.parseInt(indayS);
		int outday = Integer.parseInt(outdayS);
		String inyearS = indayS.substring(0, 4); int inyear = Integer.parseInt(inyearS);
		String outyearS = outdayS.substring(0, 4); int outyear = Integer.parseInt(outyearS);
		String inmonthS = indayS.substring(4, 6); int inmonth = Integer.parseInt(inmonthS);
		String outmonthS = outdayS.substring(4, 6); int outmonth = Integer.parseInt(outmonthS);
		String indateS = indayS.substring(6, 8); int indate = Integer.parseInt(indateS);
		String outdateS = outdayS.substring(6, 8); int outdate = Integer.parseInt(outdateS);
		System.out.println("년 : "+inyear+", 월 : "+inmonth+"일 : "+indate);
		int days = 0;
		if(inyear==outyear && inmonth==outmonth) {
			days=outday-inday;
		} else if(inyear==outyear && inmonth!=outmonth) {
			if(inmonth==1 || inmonth==3 || inmonth==5 || inmonth==7 || inmonth==8 || inmonth==10) {
				days=outday-inday-69;
			} else if(inmonth==2) {
				if(inyear%4==0 && inyear%100 !=0 || inyear%400==0) {
					days=outday-inday-72;
				} else {
					days=outday-inday-71;
				}
			} else days=outday-inday-70;
		} else if(inyear!=outyear) days=outday-inday-69-8800;
		
		int price = 0;
		price = oneday*days;
		
		
		
		System.out.println("하루 가격 : "+oneday+", 일수 : "+days+", 총 가격 : "+price);
		
		
		return price;
	}


	public bookDto getbookdetail(int bdseq) {
		bookDto bdto = new bookDto();
		String sql = "select * from book_view where bdseq=?";
		con = Dbman.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bdseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bdto.setBdseq(rs.getInt("bdseq"));
				bdto.setBooknum(rs.getInt("booknum"));
				Timestamp checkin = rs.getTimestamp("checkin");
				Timestamp checkout = rs.getTimestamp("checkout");
				bdto.setCheckin(rs.getTimestamp("checkin"));
				bdto.setCheckout(rs.getTimestamp("checkout"));
				bdto.setId(rs.getString("id"));
				bdto.setKind(rs.getString("kind"));
				bdto.setName(rs.getString("name"));
				int oneday = rs.getInt("price");
				bdto.setPrice(days(oneday, checkin, checkout));
				/* bdto.setPrice(rs.getInt("price")); */
				bdto.setResult(rs.getString("result"));
				bdto.setUsernum(rs.getInt("usernum"));
				bdto.setHotelnum(rs.getInt("hotelnum"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		
		return bdto;
	}


	public void bookcancel(int bdseq) {
		String sql = "update bookdetail set result=? where bdseq=?";
		con = Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "3");
			pstmt.setInt(2, bdseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		
	}


	public int getCancelAllCount() {
		int count=0;
		String sql = "select count(*) as cnt from "
				+ "(select * from BOOK_VIEW where result='2')";
		
		con=Dbman.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) count=rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}


	public ArrayList<bookDto> getbookcancellist(Paging paging) {
		ArrayList<bookDto> list = new ArrayList<bookDto>();
		String sql = "select * from ( select * from (select rownum as rn, b.* from "
				+ "( ( select * from book_view where result='2' "
				+ "order by result, booknum desc) b) ) where rn>=? ) where rn<=?";
		
		con = Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bookDto bdto = new bookDto();
				bdto.setBdseq(rs.getInt("bdseq"));
				bdto.setBooknum(rs.getInt("booknum"));
				Timestamp checkin = rs.getTimestamp("checkin");
				Timestamp checkout = rs.getTimestamp("checkout");
				bdto.setCheckin(rs.getTimestamp("checkin"));
				bdto.setCheckout(rs.getTimestamp("checkout"));
				bdto.setId(rs.getString("id"));
				bdto.setKind(rs.getString("kind"));
				bdto.setName(rs.getString("name"));
				int oneday = rs.getInt("price");
				bdto.setPrice(days(oneday, checkin, checkout));
				/* bdto.setPrice(rs.getInt("price")); */
				bdto.setResult(rs.getString("result"));
				bdto.setUsernum(rs.getInt("usernum"));
				bdto.setHotelnum(rs.getInt("hotelnum"));
				list.add(bdto);
			}
		} catch (SQLException e) {	e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}


	public void updateBookResult(String bdseq) {
		String sql = "update bookdetail set result='1' where bdseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bdseq));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

}
