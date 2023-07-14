package com.reservation.reserve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashSet;

import com.reservation.console.Coloring;
import com.reservation.console.ConsoleUtil;

public class ReserveServer {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public static void serverRun() throws IOException, InterruptedException {
		ReserveDAO dao = new ReserveDAO();
//		######  Field: needed to create new reservation(userID is already defined in class User.)
		int gameID;
		String seatType;
		int seatBlock;
//		################################################################################
		
		dao.showGameList();
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n") + "게임번호:");
		
		// gameID = 경기 번호를 선택하고 좌석 선택 페이지로 이동.
		gameID = ConsoleUtil.receiveNaturalNumber();
		System.out.println("\n" + gameID + "번 경기를 선택하셨습니다. \n관람을 원하시는 좌석을 선택하여 주십시오.");
		dao.showSeatList(gameID);
		
		// 원하는 좌석을 선택하고 블럭 선택 페이지로 이동.
		System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.(대소문자를 구분하지 않습니다.)\n\n좌석종류 입력: ");
		seatType = ConsoleUtil.receiveSeatType();
		
		//블럭 선택.
		HashSet<Integer> seatBlockSeat = dao.showSeatBlock(seatType);
		seatBlock = 0; // premium석 선택한 경우 기본값인 0을 seatBlock번호로 가지고 진입.
		if(!seatType.equals("premium")) {
			System.out.println(seatType + "석 블럭중, 관람을 원하시는 블럭 번호를 입력하여 주십시오.");
			while(true){
				System.out.print("블럭번호: ");
				seatBlock = ConsoleUtil.receiveNaturalNumber();
				if(seatBlockSeat.contains(seatBlock)){
					break;
				} else {
					Coloring.redOut("예매 가능한 블럭 번호가 아닙니다. 다시 입력해 주십시오.");
				}
			}
		}
		
		// 선택한 예매 정보를 종합하여 update 쿼리로 전달.
		dao.selectSeat(gameID, seatType, seatBlock);
		Thread.sleep(300);
		Coloring.cyanOut("예매가 완료되었습니다. 감사합니다.");
		Thread.sleep(1000);

		// 초기화면으로 돌아가기
		ConsoleUtil.showCommand();
	}
}
