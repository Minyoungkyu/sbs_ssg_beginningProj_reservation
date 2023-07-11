package com.reservation.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static String userCommand;
	
	public static void CLIrun() throws IOException {
		System.out.println("😉 예매 및 좌석 페이지입니다 😉\n" + ConsoleMessage.commandList + "\n\n명령어 입력대기: ");
		// 받은 명령어가 "exit"가 아니라면 계속해서 명령어 입력대기 상태를 반복.
		while(!(userCommand = rd.readLine()).equals("exit")){
			switch(userCommand){
				case "seat.reserve": 
					
					break;
					
				case "seat.cancel":
					break;
					
				case "seat.info":
					break;
					
				case "command.ls": // 명령어 리스트 보기.
					System.out.println("\n" + ConsoleMessage.commandList);
					break;
					
				default:
					ColorText.redOut("Exception: 실행 가능한 명령어가 아닙니다.");
					break;
			}
		}
		ColorText.redOut("프로세스가 종료되었습니다.");
	}
}
