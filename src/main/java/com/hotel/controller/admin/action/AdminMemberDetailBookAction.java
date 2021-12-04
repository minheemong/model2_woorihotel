package com.hotel.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminBookDao;

import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.bookDto;
import com.hotel.utill.Paging;

public class AdminMemberDetailBookAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/adminMemberDetailBook.jsp";
		System.out.println(1);
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto)session.getAttribute("loginAdmin");
		int page=1;
		
		String booknums="";
		String indate="";
		String outdate="";
		String id="";
		if(adto==null) url = "hotel.do?command=adminloginForm";
		else {
		 id=request.getParameter("id");
		 System.out.println("id :"+id);
			
		}
		Paging paging = new Paging();
		paging.setPage(page);
		
		System.out.println(2);
		AdminBookDao abdao = AdminBookDao.getInstance();
		
		int count=abdao.getAllCount(paging, id, booknums, indate, outdate);
		paging.setTotalCount(count);
		
		ArrayList<bookDto> list= abdao.getbooklist(id, paging, booknums,indate, outdate);
		

		request.setAttribute("list", list);
		
			

		System.out.println(3);

		
		request.getRequestDispatcher(url).forward(request, response);
	
	}
}
