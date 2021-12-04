package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.hotel.Dao.AdminDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.QnaDto;

public class AdminQnaRepsaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=adminQnaList";
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto) session.getAttribute("loginAdmin");
	
			AdminDao adao = AdminDao.getInstance();
			QnaDto qdto = new QnaDto();
			
			qdto.setQnaseq(Integer.parseInt(request.getParameter("qnaseq")));
			qdto.setReply(request.getParameter("reply"));
			// 답글저장 및 답글 상태 변경 '1' - > '2'
			adao.updateQna(qdto);
			// 원래 보던 qna 페이지로 이동
			url = url + "&qnaseq=" + request.getParameter("qnaseq");
		
		response.sendRedirect(url);


	}

}
