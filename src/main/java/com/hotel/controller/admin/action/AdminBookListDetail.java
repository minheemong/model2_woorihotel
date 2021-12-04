package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminBookDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;

public class AdminBookListDetail implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/book/listbookcheck.jsp";
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto)session.getAttribute("loginAdmin");
		int gotonum = Integer.parseInt(request.getParameter("gotonum"));
		if(adto==null) url = "hotel.do?command=adminloginForm";
		else {
			int bdseq = Integer.parseInt(request.getParameter("bdseq"));
			
			AdminBookDao abdao = AdminBookDao.getInstance();
			bookDto bdto = abdao.getbookdetail(bdseq);
			request.setAttribute("bookcheck", bdto);
			request.setAttribute("gotonum", gotonum);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
