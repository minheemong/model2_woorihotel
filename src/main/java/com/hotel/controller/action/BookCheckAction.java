package com.hotel.controller.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.BookDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;

public class BookCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "contact/bookcheck.jsp";
		
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser");
		
		if(mdto == null) url = "hotel.do?command=login";
		else {
			String id=mdto.getId();
			BookDao bdao = BookDao.getInstance();
			bookDto bdto = bdao.bookcheck(id);
			request.setAttribute("bookcheck", bdto);
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		

	}

}
