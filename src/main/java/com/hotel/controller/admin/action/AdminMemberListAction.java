package com.hotel.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.AdminDao;
import com.hotel.controller.action.Action;
import com.hotel.dto.AdminDto;
import com.hotel.dto.MemberDto;
import com.hotel.utill.Paging;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/member/adminmemberList.jsp";

		
			HttpSession session=request.getSession();
		
			AdminDto adto=(AdminDto)session.getAttribute("loginAdmin");
			
			System.out.println(1);
			int page=1;
			
			if( adto==null) {
				url="hotel.do?command=adminloginForm";
				
			}else {		
				
				String key="";
				if(request.getParameter("key")!=null) {
					key=request.getParameter("key");
					session.setAttribute("key", key);
				}else if( session.getAttribute("key")!= null ) {
					key =(String) session.getAttribute("key");
				} else {
					session.removeAttribute("key");
					key="";
				}
				
				
				if( request.getParameter("page") != null ) {
					page = Integer.parseInt(request.getParameter("page"));
					session.setAttribute("page", page);
				} else if( session.getAttribute("page")!= null ) {
					page = (int) session.getAttribute("page");
				} else {
					page = 1;
					session.removeAttribute("page");
				}	
				
				Paging paging  = new Paging(); 
				paging.setPage(page); 
			
		
			
				AdminDao adao = AdminDao.getInstance();
				
				/*
				 * int count = adao.getAllCountmember(key); pagingmember.setTotalCount(count);
				 */
				
				int count  = adao.getAllCount("hotelmember", "name", "id" , key);
				paging.setTotalCount(count);
			
				System.out.println(2);
				
				ArrayList<MemberDto> memberList=adao.listmember(paging,key);
				
				request.setAttribute("memberList", memberList);
				request.setAttribute("paging", paging);
				request.setAttribute("key", key);
				
			}
			System.out.println(3);
			request.getRequestDispatcher(url).forward(request, response);
	}

}
