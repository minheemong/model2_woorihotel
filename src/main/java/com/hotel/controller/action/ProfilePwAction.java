package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;

public class ProfilePwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/profilePw.jsp";
		
		HttpSession session = request.getSession();
		MemberDto mvo = (MemberDto)session.getAttribute("loginUser"); 
		if(mvo==null) {
			url = "hotel.do?command=login";
		} else {
	    	session.setAttribute("loginUser", mvo);
 		}
		
		/*
		 * String id=request.getParameter("id");
		 * 
		 * MemberDao mdao = MemberDao.getInstance(); MemberDto mvo = mdao.getMember(id);
		 * 
		 * HttpSession session=request.getSession(); session.setAttribute("loginUser",
		 * mvo);
		 */
    	
    	
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
