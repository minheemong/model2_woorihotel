package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.MemberDto;

public class AdminMemberDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/adminmemberDetail.jsp";
		HttpSession session = request.getSession();
		AdminDto avo = (AdminDto) session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "hotel.do?command=adminloginForm";
		}else {
			String id = request.getParameter("id");
			// 이미 만들어져있는 메서드 사용
			System.out.println(id);
			MemberDao mdao = MemberDao.getInstance();
			MemberDto mvo = mdao.getMember(id);
			
			request.setAttribute("memberDto", mvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
