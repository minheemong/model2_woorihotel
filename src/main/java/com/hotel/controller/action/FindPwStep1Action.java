package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;

public class FindPwStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDto mvo = mdao.confirmIdnamePhone(id,name,phone);
		String url = "member/findPwconfirmNumber.jsp";
		if(mvo == null) {
			request.setAttribute("msg", "아이디, 이름과 전화번호가 일치하는 회원이 없습니다.");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findPwForm.jsp";
		}// 널이면 되돌아가고, 검색결과가 있으면 인증번호 입력하러 가고
		request.setAttribute("member", mvo);
		request.getRequestDispatcher(url).forward(request, response);	}

}
