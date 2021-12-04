package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.QnaDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.QnaDto;

public class QnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
		 
		System.out.println(1);
		 
		 QnaDto qdto=new QnaDto();
		 
		 
		int qnaseq=Integer.parseInt(request.getParameter("qnaseq"));
		 				System.out.println(2);
		
	
		
		System.out.println(3);
		qdto.setQnaseq(qnaseq);
		qdto.setTitle(request.getParameter("title"));
		qdto.setContent(request.getParameter("content"));
		qdto.setId(request.getParameter("id"));
		
		qdto.setReply(request.getParameter("reply"));
		qdto.setRep(request.getParameter("rep"));
		
		
		QnaDao qdao=QnaDao.getInstance();
		qdao.updateQna(qdto);
							
						System.out.println(6);
		RequestDispatcher dp = request.getRequestDispatcher(
				"hotel.do?command=qnaList");
		dp.forward(request, response);
	    	
	}

	    
	    
	    
	    
	}

