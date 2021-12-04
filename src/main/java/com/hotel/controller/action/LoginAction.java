package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hotel.Dao.MemberDao;

import com.hotel.dto.MemberDto;



public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="member/login.jsp";
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
	    MemberDto mdto = mdao.getMember(id); 
		/*
		 * AdminDao adao= AdminDao.getInstance(); AdminDto adto= adao.getMember(id);
		 */

	    if( mdto == null ) {
	    	request.setAttribute("message", "아이디가 없어요");
	    } else if( mdto.getPwd() == null ) {
	    	request.setAttribute("message", "회원정보 오류. 관리자에게 문의하세요");
	    } else if( !mdto.getPwd().equals(pwd) ) {
	    	request.setAttribute("message", "비밀번호가 틀려요");
	    } else {
	    	HttpSession session=request.getSession();
	    	session.setAttribute("loginUser", mdto);
	    	url="hotel.do?command=mainForm";
	    }
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	}

