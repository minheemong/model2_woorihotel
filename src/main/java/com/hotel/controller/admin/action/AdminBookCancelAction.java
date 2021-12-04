package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminBookDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;

public class AdminBookCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gotonum = Integer.parseInt(request.getParameter("gotonum"));
		String url = "";
		if(gotonum==1) url="hotel.do?command=adminbookList";
		else if(gotonum==2) url="hotel.do?command=adminbookcancelpage";
		/*"hotel.do?command=adminbookList";*/
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto)session.getAttribute("loginAdmin");
		
		if(adto==null) url = "hotel.do?command=adminloginForm";
		else {
			int bdseq = Integer.parseInt(request.getParameter("bdseq"));
			AdminBookDao abdao = AdminBookDao.getInstance();
			abdao.bookcancel(bdseq);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
