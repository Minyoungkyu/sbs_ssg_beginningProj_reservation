package com.reservation.reserve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.reservation.console.ColorText;
import com.reservation.console.ConsoleUtil;

public class ReservationServer {
	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public static void serverRun() {
		ReservationDAO dao = new ReservationDAO();
		try {
			// 예매 가능한 게임 리스트 보이기.
			dao.showGameList();
			System.out.print(ColorText.green + "관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n" + ColorText.exit + "게임번호:");

			// 관람할 경기를 선택.
			int game_id = Integer.parseInt(rd.readLine());
			System.out.println("\n" + game_id + "번 경기를 선택하셨습니다. \n관람을 원하시는 좌석을 선택하여 주십시오.");
			
			//관람을 원하는 좌석종류를 선택.
			dao.showSeatList(game_id);
			System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.(대소문자를 구분하지 않습니다.)\n\n좌석종류 입력: ");
			String seatType = rd.readLine().toLowerCase();
			
			// 좌석 블록 보이기
			dao.showSeatBlock(seatType);
			int seatBlock = 0;
			if(!seatType.equals("premium")){
				System.out.println(seatType + "석 블럭중, 관람을 원하시는 블럭 번호를 입력하여 주십시오.");
				System.out.print("블럭번호: ");
				seatBlock = Integer.parseInt(rd.readLine());
			}
			// 좌석 선택후 예매 완료
			dao.selectSeat(game_id, seatType, seatBlock);
			ColorText.cyanOut("예매가 완료되었습니다. 감사합니다.");
			Thread.sleep(1000);
			
			// 초기화면으로 돌아가기
			ConsoleUtil.showCommand();
		} catch(SQLException sqlException) {
			ColorText.redOut("DB Connection Exception: " + sqlException);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
















