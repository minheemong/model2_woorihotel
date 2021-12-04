package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.QnaDao;
import com.hotel.dto.MemberDto;







public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println(1);
		HttpSession session = request.getSession();
	    MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
	    System.out.println(2);
	    
	    if (mdto == null) {
	    	String url = "hotel.do?command=loginForm";
	    } else {
	    	
	    	

			
			  int qnaseq = Integer.parseInt(request.getParameter("qnaseq"));
			  System.out.println(request+"값");
			 System.out.println("qnaseq의값"+qnaseq);
			 
			 QnaDao qdao = QnaDao.getInstance();		 			  
			 
			 qdao.deleteQna(qnaseq);
		
		
	
	}
		RequestDispatcher dp = request.getRequestDispatcher("hotel.do?command=qnaList");
		dp.forward(request, response);

	}
}
	



