package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;


public class QuitAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mvo = (MemberDto)session.getAttribute("loginUser");
		mdao.deleteMember(mvo.getId());
		
		session.removeAttribute("loginUser");
		
		response.sendRedirect("hotel.do?command=mainForm");

	}

}
