package com.reservation.console;

import java.io.*;

import com.reservation.myreserve.MyreserveServer;
import com.reservation.reserve.*;
import com.reservation.user.User;

public class CLI {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static String userCommand;

	public static void CLIrun() throws IOException, InterruptedException {
		CLI.setUserId();
		System.out.print("[예매 및 좌석 페이지입니다]");
		ConsoleUtil.showCommand();
		while(!(userCommand = rd.readLine()).equals("exit")) {
			switch(userCommand) {
			case "reserve":
				ReserveServer.serverRun();
				break;

			case "myreserve":
				MyreserveServer.serverRun();
				break;

			case "info":
				break;

			case "command.ls":
				ConsoleUtil.showCommand();
				break;

			default:
				Coloring.redOut("Exception: 실행 가능한 명령어가 아닙니다.");
				break;
			}
		}
		Coloring.redOut("프로세스가 종료되었습니다.");
	}

	public static void setUserId() throws IOException {
		Coloring.greenOut("User ID를 입력하여 주십시오.");
		System.out.print("ID: ");
		int userID = ConsoleUtil.receiveNaturalNumber();
		while(true) {
			try {
				User.setID(userID);
				Coloring.greenOut("로그인 성공, " + userID + "번 회원님, 환영합니다.\n");
				break;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 유형의 ID가 아닙니다. ID는 0보다 큰 정수만 가능합니다.\n");
			} catch(Exception e) {
				e.getMessage();
			}
		}
	}
}
