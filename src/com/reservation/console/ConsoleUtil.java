package com.reservation.console;

public class ConsoleUtil {
	public static String commandList = ColorText.cyan
		+ "좌석 예매:		reserve\n"
		+ ColorText.exit
		+ "-----------------------------\n"
		+ ColorText.cyan
		+ "내 예매정보 확인:	myreserve\n"
		+ ColorText.exit
		+ "-----------------------------\n"
		+ ColorText.cyan
		+ "좌석 예매 취소:	cancel\n"
		+ ColorText.exit
		+ "-----------------------------\n"
		+ ColorText.cyan
		+ "좌석 정보:		info\n"
		+ ColorText.exit
		+ "-----------------------------\n"
		+ ColorText.red
		+ "프로그램 종료:	exit\n"
		+ ColorText.exit
		+ "-----------------------------\n"
		+ ColorText.green
		+ "명령어 리스트: 	command.ls"
		+ ColorText.exit;

	public static void showCommand() {
		System.out.println("\n\n" + commandList);
		System.out.print("\n>>>: ");
	}
}
