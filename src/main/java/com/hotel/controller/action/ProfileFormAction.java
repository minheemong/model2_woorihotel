package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;

public class ProfileFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=profilePw";
		HttpSession session = request.getSession();
		MemberDto mvo = (MemberDto)session.getAttribute("loginUser");
		String pwd = request.getParameter("pwd");
		if( mvo == null) { 
			request.setAttribute("message", "다시 로그인해주세요");
		}else if(pwd==""){
			request.setAttribute("message", "비밀번호를 입력해주세요");
		}else if(!mvo.getPwd().equals(pwd)){
			request.setAttribute("message", "비밀번호가 틀립니다");
		}else {
			url = "mypage/profileForm.jsp";
			session.setAttribute("loginUser", mvo);
		}  RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
