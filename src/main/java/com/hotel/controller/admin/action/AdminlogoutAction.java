package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.controller.action.Action;

public class AdminlogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		HttpSession session=request.getSession();
    	session.removeAttribute("loginAdmin");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("hotel.do?command=adminMain");
	    dispatcher.forward(request, response);


	}

}
