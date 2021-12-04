package com.hotel.controller;





import com.hotel.controller.action.Action;
import com.hotel.controller.action.BookAction;
import com.hotel.controller.action.BookCancelAction;
import com.hotel.controller.action.BookCheckAction;
import com.hotel.controller.action.BookCheckListAction;
import com.hotel.controller.action.BookFormAction;
import com.hotel.controller.action.ContactAction;
import com.hotel.controller.action.ContractAction;
import com.hotel.controller.action.FindIdFormAction;
import com.hotel.controller.action.FindIdPwdAction;
import com.hotel.controller.action.FindIdStep1Action;
import com.hotel.controller.action.FindIdStep2Action;
import com.hotel.controller.action.FindPwFormAction;
import com.hotel.controller.action.FindPwStep1Action;
import com.hotel.controller.action.FindPwStep2Action;
import com.hotel.controller.action.FindZipNumAction;
import com.hotel.controller.action.GoInfoAction;
import com.hotel.controller.action.IdCheckFormAction;
import com.hotel.controller.action.JoinAction;
import com.hotel.controller.action.JoinComAction;
import com.hotel.controller.action.JoinFormAction;
import com.hotel.controller.action.ListBookCheckAction;
import com.hotel.controller.action.LoginAction;
import com.hotel.controller.action.LoginFormAction;
import com.hotel.controller.action.LogoutAction;
import com.hotel.controller.action.MainFormAction;
import com.hotel.controller.action.ProfileFormAction;
import com.hotel.controller.action.ProfilePwAction;
import com.hotel.controller.action.ProfileUpdateAction;
import com.hotel.controller.action.PwUpdateAction;
import com.hotel.controller.action.PwUpdateFormAction;
import com.hotel.controller.action.QnaDeleteAction;
import com.hotel.controller.action.QnaListAction;
import com.hotel.controller.action.QnaUpdateAction;
import com.hotel.controller.action.QnaUpdateFormAction;
import com.hotel.controller.action.QnaViewAction;
import com.hotel.controller.action.QnaWriteAction;
import com.hotel.controller.action.QnaWriteFormAction;
import com.hotel.controller.action.QuitAction;
import com.hotel.controller.action.QuitCheckAction;
import com.hotel.controller.action.QuitPwAction;
import com.hotel.controller.action.ResetPwAction;
import com.hotel.controller.action.SeoulHotelAction;
import com.hotel.controller.admin.action.AdminBookCancelAction;
import com.hotel.controller.admin.action.AdminBookCancelPageAction;
import com.hotel.controller.admin.action.AdminBookListAction;
import com.hotel.controller.admin.action.AdminBookListDetail;
import com.hotel.controller.admin.action.AdminBookSaveAction;
import com.hotel.controller.admin.action.AdminMainAction;
import com.hotel.controller.admin.action.AdminMemberDetailAction;
import com.hotel.controller.admin.action.AdminMemberDetailBookAction;
import com.hotel.controller.admin.action.AdminMemberListAction;
import com.hotel.controller.admin.action.AdminMemberUpdateAction;
import com.hotel.controller.admin.action.AdminQnaDetailAction;
import com.hotel.controller.admin.action.AdminQnaRepsaveAction;
import com.hotel.controller.admin.action.AdminloginAction;
import com.hotel.controller.admin.action.AdminloginFormAction;
import com.hotel.controller.admin.action.AdminlogoutAction;
import com.hotel.controller.admin.action.adminQnaListAction;



public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {	 return ist;	 }
	
	
	
	
	public Action getAction(String command) {
		Action ac = null;
		if (command.equals("mainForm")) ac = new MainFormAction();
		else if( command.equals("loginForm") ) ac = new LoginFormAction();
		else if( command.equals("login") ) ac = new LoginAction();
		else if( command.equals("contract") ) ac = new ContractAction();
		else if( command.equals("join") ) ac = new JoinAction();
		else if( command.equals("joinForm") ) ac = new JoinFormAction();
		
		
		
		
		else if( command.equals("contact") ) ac = new ContactAction();
		else if( command.equals("qnaList") ) ac = new QnaListAction();
		else if( command.equals("qnaWriteForm") )  ac = new QnaWriteFormAction();
		else if( command.equals("qnaWrite") ) ac  = new QnaWriteAction();
		else if( command.equals("qnaView") ) ac = new QnaViewAction();
		else if( command.equals("logout") ) ac = new LogoutAction();
		else if( command.equals("qnaDelete") ) ac = new QnaDeleteAction();
		else if( command.equals("qnaUpdateForm") ) ac = new QnaUpdateFormAction();
		else if( command.equals("qnaUpdate") ) ac = new QnaUpdateAction();
		
		
		
		
		
		
		
		else if(command.equals("goInfo")) ac = new GoInfoAction();
		else if(command.equals("seoulHotel")) ac = new SeoulHotelAction();
		// header.jsp에 문의하기 command 이름 바꿈
		/*
		 * else if(command.equals("qnaForm")) ac = new QnaFormAction(); else
		 * if(command.equals("contact")) ac = new ContactFormAction(); // header.jsp
		 * 마이페이지에 임시로 만들어서 연결함. else if(command.equals("bookCheck")) ac = new
		 * BookCheckAction(); else if(command.equals("bookChecklist")) ac = new
		 * BookCheckListAction(); else if(command.equals("listbookcheck")) ac = new
		 * ListBookCheckAction();
		 */
		/* 민희씨 회원가입 */
		else if( command.equals("findZipNum") ) ac = new FindZipNumAction();
		else if( command.equals("idCheckForm") ) ac = new IdCheckFormAction();
		else if( command.equals("findIdPwd") ) ac = new FindIdPwdAction();
		else if( command.equals("findIdForm") ) ac = new FindIdFormAction();
		else if( command.equals("findIdStep1") ) ac = new FindIdStep1Action();
		else if( command.equals("findIdStep2") ) ac = new FindIdStep2Action();
		else if( command.equals("findPwForm") ) ac = new FindPwFormAction();
		else if( command.equals("findPwStep1") ) ac = new FindPwStep1Action();
		else if( command.equals("findPwStep2") ) ac = new FindPwStep2Action();
		else if( command.equals("resetPw") ) ac = new ResetPwAction();
		else if( command.equals("joinCom") ) ac = new JoinComAction(); 
		
		/*  객실검색 and 예약.*/
			else if( command.equals("bookForm")) ac = new BookFormAction();
	      else if( command.equals("book")) ac = new BookAction();
		
		/* 어드민 입금처리 */
	      else if(command.equals("adminBookSave")) ac = new AdminBookSaveAction();
		
     		/* 어드민 로그인 로그아웃 */
		else if( command.equals("adminloginForm") ) ac = new AdminloginFormAction();
		else if( command.equals("adminlogin") ) ac = new AdminloginAction();		
		else if( command.equals("adminMain") ) ac = new AdminMainAction();
		else if( command.equals("adminlogout") ) ac = new AdminlogoutAction();
	
		
		/* 어드민 큐엔에이리스트액션 */
		else if( command.equals("adminQnaList") ) ac = new adminQnaListAction();
		else if( command.equals("adminQnaDetail") ) ac = new AdminQnaDetailAction();
		else if( command.equals("adminQnaRepsave") ) ac = new AdminQnaRepsaveAction();
	
		/* 어드민 회원리스트*/
		else if(command.equals("adminbookList")) ac = new AdminBookListAction();
		else if(command.equals("adminbooklistdetail")) ac = new AdminBookListDetail();	
		else if(command.equals("adminbookcancel")) ac = new AdminBookCancelAction();
		else if(command.equals("adminbookcancelpage")) ac = new AdminBookCancelPageAction();
		
		/* 마이페이지 영진 */
		else if(command.equals("bookCheck")) ac = new BookCheckAction();
		else if(command.equals("bookChecklist")) ac = new BookCheckListAction();
		else if(command.equals("listbookcheck")) ac = new ListBookCheckAction();
		else if(command.equals("bookcancel")) ac = new BookCancelAction();
				
		
		/* 마이페이지 민희 */
		else if(command.equals("profilePw")) ac = new ProfilePwAction();
		else if(command.equals("profileForm")) ac = new ProfileFormAction();
		else if(command.equals("profileUpdate")) ac = new ProfileUpdateAction();
		else if(command.equals("quitPw")) ac = new QuitPwAction();
		else if(command.equals("quitCheck")) ac = new QuitCheckAction();
		else if(command.equals("quit")) ac = new QuitAction();
		else if(command.equals("pwUpdateForm")) ac = new PwUpdateFormAction();
		else if(command.equals("pwUpdate")) ac = new PwUpdateAction();
		
		
		/* 민흐씨 */
		else if( command.equals("adminMemberList") ) ac = new AdminMemberListAction();
		else if( command.equals("adminMemberDetail") ) ac = new AdminMemberDetailAction();
	     else if( command.equals("adminMemberUpdate") ) ac = new AdminMemberUpdateAction();
		
	     else if( command.equals("adminMemberDetailBook") ) ac = new AdminMemberDetailBookAction();
		
		return ac;
		}
}
