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

public class QnaUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
	    
	    
	    if (mdto == null) {
	    	String url = "hotel.do?command=loginForm";
	    
	    } else {
	    
	    	int qnaseq=Integer.parseInt(request.getParameter("qnaseq"));
	    	System.out.println("qnaseq : "+qnaseq);
	    	QnaDao qdao= QnaDao.getInstance();
	    	QnaDto qdto=qdao.getQna(qnaseq);
	    	
	    	request.setAttribute("qnaDto", qdto);
	    RequestDispatcher dp=  request.getRequestDispatcher("qna/qnaUpdateForm.jsp");
	    	dp.forward(request, response);

	}

}

}