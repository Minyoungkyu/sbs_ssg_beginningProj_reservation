package com.reservation.console;


public class ConsoleMessage {
	public static String commandList = 		ColorText.cyan 
										  + "좌석 예매:		seat.reserve\n"
										  + ColorText.exit
										  +	"-----------------------------\n"
										  + ColorText.cyan 
										  +	"좌석 예매 취소:	seat.cancel\n"
										  + ColorText.exit
										  +	"-----------------------------\n"
										  + ColorText.cyan 
										  +	"좌석 정보:		seat.info\n"
										  + ColorText.exit
										  +	"-----------------------------\n"
										  + ColorText.red
										  + "프로그램 종료:	exit\n"
										  + ColorText.exit
										  +	"-----------------------------\n"										  
										  + ColorText.green
										  +	"명령어 리스트: 	command.ls" 
										  + ColorText.exit;
}
