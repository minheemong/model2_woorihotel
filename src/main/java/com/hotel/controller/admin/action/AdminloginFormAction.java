package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.controller.action.Action;

public class AdminloginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.getRequestDispatcher("admin/adminloginForm.jsp").forward(request, response);

	}

}
