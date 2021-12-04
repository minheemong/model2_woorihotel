package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	session.removeAttribute("loginUser");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("hotel.do?command=mainForm");
	    dispatcher.forward(request, response);

	}

}
