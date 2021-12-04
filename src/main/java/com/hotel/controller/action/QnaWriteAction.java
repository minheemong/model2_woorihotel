package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.QnaDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.QnaDto;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=qnaList";
		
		HttpSession session = request.getSession();
	    MemberDto mdto = (MemberDto) session.getAttribute("loginUser");    
	    
	    if (mdto == null) {
	    	url = "hotel.do?command=loginForm";
	    }else{
	    	QnaDto qdto = new QnaDto();
	    	qdto.setTitle(request.getParameter("title"));
	    	qdto.setContent(request.getParameter("content"));
	    	qdto.setId( mdto.getId());
	    	
	    	QnaDao qdao = QnaDao.getInstance();
	    	qdao.insertQna(qdto);
	    }
	    response.sendRedirect(url);

	}

	}


