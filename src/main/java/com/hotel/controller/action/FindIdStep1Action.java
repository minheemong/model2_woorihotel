package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;


public class FindIdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDto mvo = mdao.confirmPhone(name,phone);
		String url;
		if(mvo == null) {
			request.setAttribute("msg", "이름과 전화번호가 일치하는 회원이 없습니다.");
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findIdForm.jsp";
		}else {
			// 인증번호 전송
			url = "member/findIdconfirmNumber.jsp"; // 인증번호 입력 화면으로 이동
		}
		request.setAttribute("member", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
