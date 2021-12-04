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
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;
import com.hotel.utill.Paging;

public class AdminBookListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/book/adminbookchecklist.jsp";
		HttpSession session = request.getSession();
		AdminDto adto = (AdminDto)session.getAttribute("loginAdmin");
		
		int page = 1;
		String booknums="";
		String indate="";
		String outdate="";
		String id="";
		
		if(adto==null) url = "hotel.do?command=adminloginForm";
		else {
			if(request.getParameter("booknums")!=null) {
				booknums=request.getParameter("booknums");
				session.setAttribute("booknums", booknums);
			} else if(session.getAttribute("booknums")!=null) {
				booknums=(String)session.getAttribute("booknums");
			} else {
				session.removeAttribute("booknums");
				booknums="";
			}
			
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page")!=null) {
				page = (int)session.getAttribute("page");
			} else {
				page= 1;
				session.removeAttribute("page");
			}
			
			if(request.getParameter("checkins")!=null) {
				indate=request.getParameter("checkins");
				session.setAttribute("checkins", indate);
			} else if(session.getAttribute("checkins")!=null) {
				indate=(String)session.getAttribute("checkins");
			} else {
				session.removeAttribute("checkins");
				indate="";
			}
			
			if(request.getParameter("checkouts")!=null) {
				outdate=request.getParameter("checkouts");
				session.setAttribute("checkouts", outdate);
			} else if(session.getAttribute("checkouts")!=null) {
				outdate=(String)session.getAttribute("checkouts");
			} else {
				session.removeAttribute("checkouts");
				outdate="";
			}
			
			if(request.getParameter("bookid")!=null) {
				id=request.getParameter("bookid");
				session.setAttribute("bookid", id);
			} else if(session.getAttribute("bookid")!=null) {
				id=(String)session.getAttribute("bookid");
			} else {
				session.removeAttribute("bookid");
				id="";
			}
			
			if(request.getParameter("a")!=null) {
				System.out.println("파라미터 a 값 : "+request.getParameter("a"));
				session.removeAttribute("bookid");
				id="";
				session.removeAttribute("checkins");
				indate="";
				session.removeAttribute("checkouts");
				outdate="";
				session.removeAttribute("booknums");
				booknums="";
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminBookDao abdao = AdminBookDao.getInstance();
			int count=abdao.getAllCount(paging, id, booknums, indate, outdate);
			paging.setTotalCount(count);
			
			ArrayList<bookDto> list = abdao.getbooklist(id, paging, booknums,indate, outdate);
			int total = count;
			request.setAttribute("booklist", list);
			request.setAttribute("total", total);
			request.setAttribute("paging", paging);
			request.setAttribute("booknums", booknums);
			request.setAttribute("checkins", indate);
			request.setAttribute("checkouts", outdate);
			request.setAttribute("bookid", id);
			
			System.out.println(total);
			System.out.println(id);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
