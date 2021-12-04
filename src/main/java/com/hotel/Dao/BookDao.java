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

public class BookDao {
	private BookDao() {}
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<bookDto> confirmRoom(String checkin, String checkout, String string) {
		
		con = Dbman.getConnection();
		String sql ="select * from book_view where checkout > to_date(?,'yyyy-mm-dd')"
				+ "and checkin < to_date(?,'yyyy-mm-dd') and kind = ?";
		ArrayList<bookDto> list = new ArrayList<>();
		bookDto bdto = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, checkin);
			pstmt.setString(2, checkout);
			pstmt.setString(3, string);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bdto = new bookDto();
				bdto.setBdseq(rs.getInt("bdseq"));
				bdto.setBooknum(rs.getInt("booknum"));
				bdto.setCheckin(rs.getTimestamp("checkin"));
				bdto.setCheckout(rs.getTimestamp("checkout"));
				bdto.setId(rs.getString("id"));
				bdto.setKind(rs.getString("kind"));
				bdto.setName(rs.getString("name"));
				bdto.setPrice(rs.getInt("price"));
				bdto.setResult(rs.getString("result"));
				bdto.setUsernum(rs.getInt("usernum"));
				bdto.setHotelnum(rs.getInt("hotelnum"));
				
				list.add(bdto);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public void insertRoom(ArrayList<Integer> remainList, int oldRoomnum, int oldUsernum, String id, ArrayList<Integer> userNumList, String oldCheckin, String oldCheckout) {
		int booknum = 0;
		
		String sql = "insert into book values (seq_book_booknum.nextval,?)";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "select max(booknum) as max_booknum from book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) booknum = rs.getInt("max_booknum");
			pstmt.close();
			
			for(int i = 0 ; i<oldRoomnum; i++) {
				sql = "insert into bookdetail (usernum,checkin,checkout,bdseq,booknum,hotelnum)"
						+ "values(?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),seq_bookdetail_bdseq.nextval,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userNumList.get(i));
				pstmt.setString(2, oldCheckin);
				pstmt.setString(3, oldCheckout);
				pstmt.setInt(4, booknum);
				pstmt.setInt(5, remainList.get(i));
				pstmt.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	


	public bookDto bookcheck(String id) {
		bookDto bdto = null;
		String sql = "select * from book where booknum=(select max(booknum) from book where id=?)";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// 가장 최근 예약 번호
			if(rs.next()) {
				bdto = new bookDto();
				bdto.setBooknum(rs.getInt("booknum"));
			}
			
			pstmt.close();
			sql = " select * from book_view where booknum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bdto.getBooknum());
			rs = pstmt.executeQuery();
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


	public ArrayList<bookDto> getbooklist(String id, Paging paging, String booknums,
			String indate, String outdate) {
		ArrayList<bookDto> list = new ArrayList<bookDto>();
		/* String sql = "select * from book_view where id=?"; */
		String sql="";
		
		con=Dbman.getConnection();
		try {
			if(booknums=="" && indate=="" && outdate=="") {
				sql=" select * from( "
						+ " select * from ("
						+ " select rownum as rn, b.* from "
						+ "( (select * from book_view where id=? order by booknum desc) b )"
						+ " ) where rn>=?"
						+ " ) where rn<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());}
			else if(booknums=="" && indate!="" || outdate!="") {
				if(indate!="" && outdate!="") {
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? order by booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setString(3, outdate);
					pstmt.setInt(4, paging.getStartNum());
					pstmt.setInt(5, paging.getEndNum());
				} else if(indate=="" && outdate!=""){
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkout, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, outdate);
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
				} else if(indate!="" && outdate=="") {
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and to_char(checkin, 'YYYYMMDD')=? "
							+ " order by booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
				}
			}
			else{
					sql=" select * from( "
							+ " select * from ("
							+ " select rownum as rn, b.* from "
							+ "( (select * from book_view where id=? "
							+ "and booknum=? order by booknum desc) b )"
							+ " ) where rn>=?"
							+ " ) where rn<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setInt(2,Integer.parseInt(booknums));
					pstmt.setInt(3, paging.getStartNum());
					pstmt.setInt(4, paging.getEndNum());
			}
			
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


	public bookDto getbookcheck(int bdseq) {
		bookDto bdto = new bookDto();
		String sql = "select * from book_view where bdseq=?";
		con=Dbman.getConnection();
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
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "2");
			pstmt.setInt(2, bdseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
	}


	public int getAllCount(String id) {
		int count = 0;
		String sql = "select count(*) as cnt from book where id=?";
		
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}
	public int getAllCount(String id, String booknums, String indate, String outdate) {
		int count = 0;
		/* String sql = "select count(*) as cnt from book where id=?"; */
		String sql = "";
		
		con=Dbman.getConnection();
		try {
			if(booknums=="" && indate=="" && outdate=="") {
				sql = "select count(*) as cnt from book_view where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
			} else if(booknums!="" && indate==""&&outdate=="") {
				sql="select count(*) as cnt from book_view where id=? and booknum=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, booknums);
			} else if(booknums=="" && indate!="" || outdate!="") {
				if(indate!="" && outdate!="") {
					sql = "select count(*) as cnt from book_view where id=?"
							+ " and to_char(checkin, 'YYYYMMDD')=? "
							+ " and to_char(checkout, 'YYYYMMDD')=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
					pstmt.setString(3, outdate);
				} else if(indate=="" && outdate!="") {
					sql = "select count(*) as cnt from book_view where id=?"
							+ " and to_char(checkout, 'YYYYMMDD')=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, outdate);
				} else if(indate!="" && outdate=="") {
					sql = "select count(*) as cnt from book_view where id=?"
							+ " and to_char(checkin, 'YYYYMMDD')=? ";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, indate);
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}

	
	
}
