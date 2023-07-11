package com.reservation.reserve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.reservation.console.ColorText;

public class ReservationServer {
	static Reservation rsv;

	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public static void serverRun() {
		ReservationDAO dao = new ReservationDAO();
		try {
			// 예매 가능한 게임 리스트 보이기.
			dao.showGameList();
			System.out.print(ColorText.green + "관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n" + ColorText.exit + "게임번호:");

			// 관람할 경기를 선택.
			int game_id = Integer.parseInt(rd.readLine());
			System.out.println("\n" + game_id + "번 게임을 선택하셨습니다. \n관람을 원하시는 좌석을 선택하여 주십시오.");
			
			//관람을 원하는 좌석종류를 선택.
			dao.showSeatList(game_id);
			System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.(대소문자를 구분하지 않습니다.)\n\n좌석종류 입력: ");
			String seat = rd.readLine().toLowerCase();
			
			// 좌석 선택.
			dao.selectSeat(game_id, seat);

		} catch(Exception e) {
			ColorText.redOut("DB connection Exception: " + e);
		}
	}
}
