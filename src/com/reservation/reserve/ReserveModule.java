package com.reservation.reserve;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

import com.reservation.console.Coloring;
import com.reservation.console.ConsoleUtil;
import com.reservation.console.GameCalendar;
import com.reservation.console.SQL;
import com.reservation.data.user.User;

public class ReserveModule {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static ReserveDAO dao = new ReserveDAO();

	public static void moduleRun() throws IOException, InterruptedException {

		boolean show_preferred_game_schedule = Games.showGameList(dao);
		if(show_preferred_game_schedule){
			Games.choiceGamebyDay();						
		} else {
			Games.choiceGamebyId();			
		}
		
		Seats.choiceSeatType(dao);
		Seats.choiceSeatBlock(dao);

		// 선택한 예매 정보를 종합하여 update 쿼리로 전달.
		dao.addNewReservation(Games.gameId, Seats.seatType, Seats.seatBlock);
		Thread.sleep(300);
		Coloring.cyanOut("예매가 완료되었습니다. 감사합니다.");
		Thread.sleep(1000);

		// 초기화면으로 돌아가기
		ConsoleUtil.showCommand();
	}
}

class Games {
	public static HashSet<Integer> gameIdSet;
	public static HashMap<Integer,Integer> game_id_map;
	public static int gameId;

	public static boolean showGameList(ReserveDAO dao) throws IOException, InterruptedException {
		Coloring.greenOut("선호하는 팀의 경기 일정만을 보시겠습니까? (Y/N)\n (N을 입력하시면 전체 일정을 봅니다.)");
		boolean user_answer = ConsoleUtil.receiveYesOrNo();
		if(user_answer) {
			Coloring.purpleOut("선호 팀: " + User.preferredClub.name + "의 경기 정보 불러오는 중..");
			Thread.sleep(1000);
			game_id_map = GameCalendar.showCalendar();
		} else {
			Coloring.purpleOut("예매 가능한 전체 경기 일정 불러오는 중..");
			Thread.sleep(1000);
			gameIdSet = dao.showGameList(SQL.select_all_games_SQL);
		}
		// 선호하는 팀의 경기 일정만을 본 경우, true return.
		return user_answer;
	}

	public static void choiceGamebyId() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n") + "게임번호:");
		gameId = ConsoleUtil.receiveContainedNum(gameIdSet);

	}
	public static void choiceGamebyDay() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기의 \'날짜(일)\'를 입력하여 주십시오.\n") + "일:");
		int game_day = ConsoleUtil.receiveContainedNum(new HashSet<Integer>(game_id_map.keySet()));
		gameId = game_id_map.get(game_day);
		
	}
}

class Seats {
	public static String seatType;
	public static int seatBlock;
	static HashSet<Integer> seatBlockSeat;

	public static void choiceSeatType(ReserveDAO dao) {
		dao.showSeatList(Games.gameId);
		System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.\n\n>>> ");
		seatType = ConsoleUtil.receiveSeatType();
	}

	public static void choiceSeatBlock(ReserveDAO dao) {
		seatBlockSeat = dao.showSeatBlock(seatType);
		seatBlock = 0; // premium석 선택한 경우 기본값인 0을 seatBlock번호로 가지고 진입.
		if(!seatType.equals("premium")) {
			System.out.println(seatType + "석 블럭중, 관람을 원하시는 블럭 번호를 입력하여 주십시오.");
			seatBlock = ConsoleUtil.receiveContainedNum(seatBlockSeat);
		}
	}
}
