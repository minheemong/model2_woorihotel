package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.hotel.Dao.QnaDao;
import com.hotel.controller.action.Action;

import com.hotel.dto.QnaDto;

public class AdminQnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "admin/qna/adminqnaDetail.jsp";
			
			System.out.println(0);
			String qnaseq = request.getParameter("qnaseq");
			System.out.println(1);
			// Qna 하나를 검색하고 리턴 받는 코드
			QnaDao qdao = QnaDao.getInstance();
			System.out.println(2);
			QnaDto qdto = qdao.getQna(Integer.parseInt(qnaseq));
			// 리턴 받은 qna 를 request에 저장하는 코드
			request.setAttribute("qnaDto", qdto);
			System.out.println(3);
		request.getRequestDispatcher(url).forward(request, response);

		System.out.println(4);
	}

}
