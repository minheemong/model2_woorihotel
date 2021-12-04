package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;


public class ResetPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디와 패스워드 전달받기
				MemberDto mvo = new MemberDto();
				mvo.setId(request.getParameter("id"));
				mvo.setPwd(request.getParameter("pwd"));
				
				// 패스워드 수정
				MemberDao mdao = MemberDao.getInstance();
				mdao.resetPw(mvo);
				
				// 패스워드 리셋 완료 페이지로 이동
				String url ="member/resetPwComplete.jsp";
				request.getRequestDispatcher(url).forward(request, response);
	}

}
