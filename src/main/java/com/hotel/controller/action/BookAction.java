package com.hotel.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Dao.BookDao;
import com.hotel.dto.MemberDto;
import com.hotel.dto.bookDto;

public class BookAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser");
		String url;
		if(mdto == null) {
			url = "hotel.do?command=loginForm";
		}else {
		
			// 필요한 변수들 지정
			String oldCheckin = request.getParameter("oldCheckin");
			String oldCheckout = request.getParameter("oldCheckout");
			int oldUsernum = Integer.parseInt(request.getParameter("oldUsernum"));
			int oldRoomnum = Integer.parseInt(request.getParameter("oldRoomnum"));
			String kind = request.getParameter("kind");
			String id = mdto.getId();
			
			// 데이터 확인
			// System.out.println(oldCheckin);
			// System.out.println(oldCheckout);
			// System.out.println(oldUsernum);
			// System.out.println(oldRoomnum);
			// System.out.println(kind);
			
			// Deluxe 방 추가
			ArrayList<Integer> DList = new ArrayList<>();
			DList.add(1101);
			DList.add(1102);
			DList.add(1103);
			DList.add(1104);
	        DList.add(1105);
	        DList.add(1106);
	        DList.add(1107);
			
			// Business Deluxe
			ArrayList<Integer> BDList = new ArrayList<>();
			BDList.add(1201);
			BDList.add(1202);
			BDList.add(1203);
			BDList.add(1204);
	        BDList.add(1205);
	        BDList.add(1206);
	        BDList.add(1207);
			
			// Grand Corner Deluxe
			ArrayList<Integer> GCDList = new ArrayList<>();
			GCDList.add(1301);
			GCDList.add(1302);
			GCDList.add(1303);
			GCDList.add(1304);
	        GCDList.add(1305);
	        GCDList.add(1306);
	        GCDList.add(1307);
			// Execuive Business Deluxe
			ArrayList<Integer> EBDList = new ArrayList<>();
			EBDList.add(1401);
			EBDList.add(1402);
			EBDList.add(1403);
			EBDList.add(1404);
	        EBDList.add(1405);
	        EBDList.add(1406);
	        EBDList.add(1407);
			
			// 나머지 방 담을 리스트!(예약안된 방 담을 리스트)
			ArrayList<Integer> remainList = new ArrayList<>();
			
			// 예약되어 있는거 방 산출
			BookDao bdao = BookDao.getInstance();
			
			ArrayList<bookDto> list = new ArrayList<>();
			list = bdao.confirmRoom(oldCheckin, oldCheckout, kind);
			
			// 산출후 호수만 list에 저장 (예약된 방 리스트 (호수만))
			ArrayList<Integer> reservedList = new ArrayList<>();
			for(int i=0 ; i<list.size();  i++) {
				reservedList.add(list.get(i).getHotelnum());
			}
			
			// kind 에 따른 리스트 불러오기(모든방이 담긴 리스트)
			if(kind.equals("Deluxe")) {
				// 디럭스 인거 확인후 remainList에다가 DList 값 insert  (deep copy)
				for(Integer i : DList) {
					remainList.add(i);
				}
				// remainList - reservedList ( 차집합)
				// 여기까지하면 remainList에 예약안된것만 들어있다
				remainList.removeAll(reservedList);
			} else if(kind.equals("Business Deluxe")){
				for(Integer i : BDList) {
					remainList.add(i);
				}
				remainList.removeAll(reservedList);
			} else if(kind.equals("Grand Corner Deluxe")) {
				for(Integer i : GCDList) {
					remainList.add(i);
				}
				remainList.removeAll(reservedList);
			} else if(kind.equals("Executive Business Deluxe")) {
				for(Integer i : EBDList) {
					remainList.add(i);
				}
				remainList.removeAll(reservedList);
			}
			
			
			
			// 인원도 분배해야하네 하... 
			// 최대인원 먼저 다채우고 다머지!(이러면 안돼)
			// 4  13  3  3 3 3  평균값으로 일단 다채워
			ArrayList<Integer> userNumList = new ArrayList<>();
			int a = oldUsernum / oldRoomnum ;  // 몫
			int b = oldUsernum % oldRoomnum; // 나머지
			
			// 인원분배
			for(int i = 0 ; i<oldRoomnum ; i++) { //방갯수만큼반복
				userNumList.add(a);
			}
			for(int i = 0 ; i<b ; i ++) {
				userNumList.set(i, userNumList.get(i)+1);
			}
			
			// 확인
			//for(Integer c : userNumList ) {
			//	System.out.println("인원 : " + c);
			//}
			//for(Integer d : remainList) {
			//	System.out.println("남은방 방호수 : " + d);
			//}
			
			
			
			
			bdao.insertRoom(remainList,oldRoomnum,oldUsernum,id,userNumList,oldCheckin,oldCheckout);
			
			url ="hotel.do?command=bookChecklist";
		}
		response.sendRedirect(url);
		
		
		
		

	}

}
