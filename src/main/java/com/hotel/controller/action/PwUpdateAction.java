package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.MemberDto;

public class PwUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel.do?command=pwUpdateForm";
		HttpSession session = request.getSession();
		MemberDto mvo = (MemberDto)session.getAttribute("loginUser");
		String pwd = request.getParameter("pwd");
		String newpwd = request.getParameter("newpwd");
		String newpwd_re = request.getParameter("newpwd_re");
		if( mvo == null) { 
			request.setAttribute("message", "다시 로그인해주세요");
		}else if(pwd.equals(null)){ 
	// 현재 비밀번호 확인
			request.setAttribute("message", "현재 비밀번호를 입력해주세요");
		}else if(!mvo.getPwd().equals(pwd)){
			request.setAttribute("message", "현재 비밀번호가 틀립니다");
		}else {
	// 새 비밀번호 확인
			if(newpwd.equals(null)) {
				request.setAttribute("message", "새 비밀번호를 입력해주세요");
			} else if(newpwd_re.equals(null)) {
				request.setAttribute("message", "새 비밀번호 확인을 입력해주세요");
			} else if(!newpwd_re.equals(newpwd)) {
				request.setAttribute("message", "새 비밀번호 확인이 일치하지 않습니다");
			} else {
				MemberDao mdao = MemberDao.getInstance();
				mvo.setPwd(newpwd);
				mdao.updateMember(mvo);
				request.setAttribute("message", "정상적으로 수정되었습니다");
			}
		}  
		session.setAttribute("loginUser", mvo);
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
