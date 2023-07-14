package com.reservation.cancel;

public class ReservationCancel {

	public static void serverRun() {
		ReservationCancelDAO dao = new ReservationCancelDAO();
		try {
			dao.cancelReservation();
		} catch(Exception e) {
			e.getMessage();
		}
	}
}

