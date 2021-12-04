package com.hotel.controller.action;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.BookDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;
import com.hotel.utill.Paging;

public class BookCheckListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="mypage/bookchecklist.jsp";
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser");
		
		int page = 1;
		String booknums="";
		String indate="";
		String outdate="";
		if(mdto==null) url="hotel.do?command=loginForm";
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
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page")!=null) {
				page = (int)session.getAttribute("page");
			} else {
				page = 1;
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
			
			if(request.getParameter("a")!=null) {
				System.out.println("파라미터 a 값 : "+request.getParameter("a"));
				session.removeAttribute("checkins");
				indate="";
				session.removeAttribute("checkouts");
				outdate="";
				session.removeAttribute("booknums");
				booknums="";
			}
			
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			BookDao bdao =BookDao.getInstance();
			int count = bdao.getAllCount(mdto.getId(), booknums, indate, outdate);
			paging.setTotalCount(count);
		
			String id=mdto.getId();
			
			ArrayList<bookDto> list = bdao.getbooklist(id,paging, booknums, indate, outdate);
			int total=count;
			request.setAttribute("booklist", list);
			request.setAttribute("total", total);
			request.setAttribute("paging", paging);
			request.setAttribute("booknums", booknums);
			request.setAttribute("checkins", indate);
			request.setAttribute("checkouts", outdate);
			
			System.out.println(total);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
