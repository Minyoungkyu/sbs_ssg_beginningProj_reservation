package com.reservation.console;

import java.io.*;

import com.reservation.data.user.User;
import com.reservation.myreserve.MyreserveServer;
import com.reservation.reserve.*;

public class CLI {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static String userCommand;

	public static void CLIrun() throws IOException, InterruptedException {
		User.setLogin();
		Thread.sleep(1500);
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

			case "myclub":
				User.changePreferredClub();
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
}
