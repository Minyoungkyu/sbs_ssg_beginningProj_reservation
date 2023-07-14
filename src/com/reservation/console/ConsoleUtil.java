package com.reservation.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ConsoleUtil {
	public static String commandList = Coloring.cyan
		+ "좌석 예매:		reserve\n"
		+ Coloring.exit
		+ "-----------------------------------------\n"
		+ Coloring.cyan
		+ "내 예매정보 확인:	myreserve\n"
		+ Coloring.exit
		+ "-----------------------------------------\n"
		+ Coloring.cyan
		+ "좌석 예매 취소:	myreserve -> 취소 페이지로 이동\n"
		+ Coloring.exit
		+ "-----------------------------------------\n"
		+ Coloring.cyan
		+ "좌석 정보:		info\n"
		+ Coloring.exit
		+ "-----------------------------------------\n"
		+ Coloring.cyan
		+ "명령어 리스트: 	command.ls\n"
		+ Coloring.exit
		+ "-----------------------------------------\n"
		+ Coloring.red
		+ "프로그램 종료:	exit"
		+ Coloring.exit;

	public static void showCommand() {
		System.out.println("\n\n" + commandList);
		System.out.print("\n>>> ");
	}
	
	public static int receiveNaturalNumber() {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				int num = Integer.parseInt(rd.readLine());
				if(num <= 0){
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("0보다 큰 정수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveNaturalNumber throw IOException!");
			}
		}
	}

	public static String receiveSeatType() {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> seatTypeSet = new HashSet<>();
		seatTypeSet.add("premium");
		seatTypeSet.add("table");
		seatTypeSet.add("blue");
		seatTypeSet.add("red");
		seatTypeSet.add("navy");
		seatTypeSet.add("green");
		while(true){
			try {
				String seatType = rd.readLine().toLowerCase();
				if(!seatTypeSet.contains(seatType)){
					throw new NumberFormatException();
				}
				return seatType;
			} catch(Exception e) {
				Coloring.redOut("올바른 좌석 유형을 입력해 주십시오.");
			}
		}
	}


}
