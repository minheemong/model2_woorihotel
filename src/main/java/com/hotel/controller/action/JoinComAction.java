package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class JoinComAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      //session.invalidate();
      session.removeAttribute("joinName");
      RequestDispatcher dp = request.getRequestDispatcher("hotel.do?command=loginForm");
      dp.forward(request, response);

      /*
       * String id = request.getParameter("id");
       * 
       * MemberDao mdao = MemberDao.getInstance(); MemberDto mvo = mdao.getMember(id);
       * 
       * HttpSession session = request.getSession();
       * session.removeAttribute("joinName");
       * 
       * response.sendRedirect("member/login.jsp");
       */
   }

}