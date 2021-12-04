package com.hotel.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hotel.Dao.QnaDao;

import com.hotel.dto.MemberDto;
import com.hotel.dto.QnaDto;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "qna/qnaList.jsp";
		
		HttpSession session = request.getSession();
	    MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
	
	    
	    if (mdto == null) {
	    	url = "hotel.do?command=loginForm";
	    } else {
	    	QnaDao qdao = QnaDao.getInstance();
	    	ArrayList<QnaDto> list = qdao.listQna( mdto.getId() ); 
	    	request.setAttribute("qnaList" , list);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

	}


