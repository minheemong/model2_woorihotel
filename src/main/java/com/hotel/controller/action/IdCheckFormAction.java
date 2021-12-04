package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.MemberDao;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.confirmID(id);
		// 아이디가 사용중이면 result:1, 사용가능한 아이디이면 result:-1
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("member/idcheck.jsp");
		dispatcher.forward(request, response);
	}

}
