package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.BookDao;

public class BookFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "bookDetail.jsp";
		
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int roomnum = Integer.parseInt(request.getParameter("roomnum"));  
		int usernum = Integer.parseInt(request.getParameter("usernum"));  
		
		BookDao bdao = BookDao.getInstance();
		
		// ture 가 되면 객실이 보이게 
		boolean DBool = false;
		boolean BDBool = false;
		boolean GCDBool = false;
		boolean EBDBool = false;
		
		// Deluxe방  D(2) BD(4) GCD(6) EBD(4)
		// 날짜입력하면 그안에 이미 예약된 방이 몇개있는지 확인
		
		int DCnt = bdao.confirmRoom(checkin,checkout,"Deluxe").size();
		int BDCnt = bdao.confirmRoom(checkin,checkout,"Business Deluxe").size();
		int GCDCnt = bdao.confirmRoom(checkin,checkout,"Grand Corner Deluxe").size();
		int EBDCnt = bdao.confirmRoom(checkin,checkout,"Executive Business Deluxe").size();
		
	
		
		
		//   D  - 2 는 가용인원   3은 D의 총 방갯수  
		if ( 2 >= usernum/roomnum && (7-DCnt) >= roomnum ) DBool = true;
		if ( 4 >= usernum/roomnum && (7-BDCnt) >= roomnum ) BDBool = true;
		if ( 6 >= usernum/roomnum && (7-GCDCnt) >= roomnum ) GCDBool = true;
		if ( 8 >= usernum/roomnum && (7-EBDCnt) >= roomnum ) EBDBool = true;
		
		
		// 체크 완벽한것 같은데
		// System.out.println(DBool);
		// System.out.println(BDBool);
		// System.out.println(GCDBool);
		// System.out.println(EBDBool);
		
		request.setAttribute("DBool", DBool);
		request.setAttribute("BDBool", BDBool);
		request.setAttribute("GCDBool", GCDBool);
		request.setAttribute("EBDBool", EBDBool);
		
		request.setAttribute("oldCheckin", checkin);
		request.setAttribute("oldCheckout", checkout);
		request.setAttribute("oldRoomnum", roomnum);
		request.setAttribute("oldUsernum", usernum);
		
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
