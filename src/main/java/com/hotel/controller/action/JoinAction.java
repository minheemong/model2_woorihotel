package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hotel.dto.MemberDto;



public class JoinAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      MemberDto mto = new MemberDto();
      mto.setId(request.getParameter("id"));
      mto.setPwd(request.getParameter("pwd"));
      mto.setName(request.getParameter("name"));
      mto.setEmail(request.getParameter("email"));
      
      mto.setZip_num(request.getParameter("zip_num"));
      
      mto.setAddress( request.getParameter("addr1") + " " + request.getParameter("addr2") );
      
      mto.setPhone(request.getParameter("phone"));

      HttpSession session=request.getSession();
       session.setAttribute("joinName", mto);
          
      response.sendRedirect("member/joinComplete.jsp");

   }

}