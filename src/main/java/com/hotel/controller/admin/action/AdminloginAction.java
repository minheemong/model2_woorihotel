package com.hotel.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;

public class AdminloginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String workId = request.getParameter("workId");
	    String workPwd = request.getParameter("workPwd");
	    
	    String url = "admin/adminloginForm.jsp";
		String msg = "";
		
		
		AdminDao adao = AdminDao.getInstance();
	 
	    AdminDto adto = adao.workerCheck(workId);
	    
	    if( adto == null) msg = "없는 아이디 입니다";
	    else if( adto.getPwd() == null ) msg = "DB 오류. 관리자에게 문의하세요";
	    else 	if( !adto.getPwd().equals(workPwd)) msg = "암호가 다릅니다";
	    else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginAdmin", adto);
	    	url = "hotel.do?command=adminMain";
	    	
	    }
	    request.setAttribute("message", msg);
	    
	    request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
