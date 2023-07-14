package com.reservation.myreserve;

import com.reservation.user.User;

public class MyreserveServer {
	static MyreserveDAO dao = new MyreserveDAO();

	public static void serverRun() {
		// TODO Auto-generated method stub
		try {
			// 예매한 정보들 리스트 보이기.
			dao.showReservationList(User.getID());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
