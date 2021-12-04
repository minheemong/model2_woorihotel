package com.hotel.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Dao.MemberDao;
import com.hotel.dto.AddressDto;


public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		if(dong!=null) {
			if(dong.equals("")==false) {
				MemberDao mdao = MemberDao.getInstance();
				ArrayList<AddressDto> list = mdao.selectAddressByDong(dong);
				request.setAttribute("addressList", list);
			}
		}else {
			// 아무것도 안하고 그냥 findZipNum.jsp로 이동
		}
		RequestDispatcher dp = request.getRequestDispatcher("member/findZipNum.jsp");
		dp.forward(request, response);

	}

}
