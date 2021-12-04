package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminBookDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;

public class AdminBookSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=adminbookList";
		
		
		
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto)session.getAttribute("loginAdmin");
		if( adto ==null) {
			url = "hotel.do?command=admin";
		} else {
			// 전달된 주문상세번호들의 주문을 미처리 -> 처리로 변경해주세요.
			AdminBookDao abdao = AdminBookDao.getInstance();
			String [] resultArr = request.getParameterValues("result");
			
			// 배열의 요소들(odseq들)을 하나씩 꺼내어 해당 주문의  처리여부를 처리로 업데이트합니다
			for(String bdseq : resultArr) {
				abdao.updateBookResult(bdseq);
			}
				
				
			
			
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}
