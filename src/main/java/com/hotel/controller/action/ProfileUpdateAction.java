package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;

public class ProfileUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		MemberDto mvo = (MemberDto)session.getAttribute("loginUser");
		mvo.setEmail(request.getParameter("email"));
		mvo.setPhone(request.getParameter("phone"));
	
		mdao.updateMember(mvo);
		
		session.setAttribute("loginUser", mvo);
		request.setAttribute("message", "정상적으로 수정되었습니다");
		RequestDispatcher dp = request.getRequestDispatcher("mypage/profileForm.jsp");
		dp.forward(request, response);
	}

}
