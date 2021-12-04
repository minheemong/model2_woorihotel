package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.dto.MemberDto;

public class QnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaWrite.jsp";
		HttpSession session = request.getSession();
	    MemberDto mdto= (MemberDto) session.getAttribute("loginUser"); 
	    
	    if (mdto == null)
	    	url = "hotel.do?command=loginForm";	    
	    	
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
