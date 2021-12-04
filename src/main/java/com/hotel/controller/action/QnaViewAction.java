package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.QnaDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.QnaDto;



public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaView.jsp";

		// QnaDao 에 추가될 메서드 이름 getQna
		HttpSession session = request.getSession();
	    MemberDto mvo = (MemberDto) session.getAttribute("loginUser");
	    if (mvo == null) {
	        url = "hotel.do?command=loginForm";
	    } else {
	    	int qnaseq = Integer.parseInt( request.getParameter("qnaseq") );
	    	QnaDao qdao = QnaDao.getInstance();
	    	QnaDto qdto = qdao.getQna(qnaseq);
	    	request.setAttribute("qnaDto",qdto);
	    }
		request.getRequestDispatcher(url).forward(request, response);

	}

}
