package com.hotel.controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.BookDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;

public class BookCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=bookChecklist";
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser");
		if(mdto==null) url="hotel.do?command=loginForm";
		else {
			int bdseq = Integer.parseInt(request.getParameter("bdseq"));
			BookDao bdao = BookDao.getInstance();
			bdao.bookcancel(bdseq);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
