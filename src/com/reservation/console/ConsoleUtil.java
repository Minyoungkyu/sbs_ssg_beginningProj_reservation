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
		+ "선호구단 정보 변경:	myclub\n"
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
		while(true) {
			try {
				int num = Integer.parseInt(rd.readLine());
				if(num <= 0) {
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
	
	public static int receiveCustomRangeNum(int start, int end) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int num = Integer.parseInt(rd.readLine());
				if(num < start || num > end) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveCustomRangeNum throw IOException!: " + e);
			}
		}
	}
	
	public static int receiveContainedNum(HashSet<Integer> set) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int num = Integer.parseInt(rd.readLine());
				if(!set.contains(num)) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveCustomRangeNum throw IOException!: " + e);
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
		while(true) {
			try {
				String seatType = rd.readLine().toLowerCase();
				if(!seatTypeSet.contains(seatType)) {
					throw new NumberFormatException();
				}
				return seatType;
			} catch(Exception e) {
				Coloring.redOut("올바른 좌석 유형을 입력해 주십시오.");
			}
		}
	}

	public static boolean receiveYesOrNo() throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print(">>>");
			String userAnswer = rd.readLine().toLowerCase();
			if(userAnswer.equals("y")) {
				return true;
			} else if(userAnswer.equals("n")) {
				return false;
			} else {
				Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
			}
		}
	}
}
