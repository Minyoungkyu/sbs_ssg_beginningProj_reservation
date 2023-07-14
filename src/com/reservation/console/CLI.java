package com.reservation.console;

import java.io.*;

import com.reservation.myreserve.MyreserveServer;
import com.reservation.reserve.*;
import com.reservation.user.User;

public class CLI {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static String userCommand;
	
	public static void CLIrun() throws IOException {
		ColorText.greenOut("User ID를 입력하여 주십시오. ID는 자연수만 가능합니다.");
		while(true){
			try {
				System.out.print("ID: ");
				User.setID(Integer.parseInt(rd.readLine()));
				break;
			} catch(Exception e) {
				ColorText.redOut("올바른 ID가 아닙니다. 다시 입력해 주십시오.\n");
			}
		}
        System.out.print("\033[H\033[2J");
        System.out.flush();
		System.out.print("😉 예매 및 좌석 페이지입니다 😉\n" + ConsoleUtil.commandList + "\n\n명령어 입력대기: ");
		// 받은 명령어가 "exit"가 아니라면 계속해서 명령어 입력대기 상태를 반복.
		while(!(userCommand = rd.readLine()).equals("exit")){
			switch(userCommand){
				case "reserve": 
					ReservationServer.serverRun();
					break;
				
				case "myreserve":
					MyreserveServer.serverRun();
					break;
				case "cancel":
					break;
					
				case "info":
					break;
					
				case "command.ls": // 명령어 리스트 보기.
					System.out.println("\n" + ConsoleUtil.commandList);
					break;
					
				default:
					ColorText.redOut("Exception: 실행 가능한 명령어가 아닙니다.");
					break;
			}
		}
		ColorText.redOut("프로세스가 종료되었습니다.");
	}
}
