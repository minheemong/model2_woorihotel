package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.MemberDto;

public class AdminMemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		String url = "admin/member/adminmemberDetail.jsp";
		AdminDto avo = (AdminDto) session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "hotel.do?command=adminloginForm";
		}else {
			String id = request.getParameter("id");
			// 이미 만들어져있는 메서드 사용
			MemberDto mvo = mdao.getMember(id);
			mvo.setEmail(request.getParameter("email"));
			mvo.setPhone(request.getParameter("phone"));
		
			mdao.updateMember(mvo);
			
			session.setAttribute("memberDto", mvo);
			request.setAttribute("message", "정상적으로 수정되었습니다");
		}
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
