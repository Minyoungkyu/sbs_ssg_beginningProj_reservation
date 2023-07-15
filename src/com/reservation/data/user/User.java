package com.reservation.data.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.reservation.console.Coloring;
import com.reservation.console.ConsoleUtil;
import com.reservation.data.club.Club;

public class User {
	static int id;
	static Club preferredClub;

	public static void setID(int id) {
		User.id = id;
	}

	public static int getID() {
		return User.id;
	}

	public static void setLogin() throws IOException, InterruptedException {
		UserDAO dao = new UserDAO();
		Coloring.greenOut("User ID를 입력하여 주십시오.");
		System.out.print("ID: ");
		int userId = ConsoleUtil.receiveNaturalNumber();
		setID(userId);
		
		// 로그인 정보가 있다면, 선호하는 구단 정보를 가져오기.
		boolean canLogin = dao.checkUserRegistrationData(userId);
		while(true){
			if(canLogin){ 
				Club preferred = Club.clubs.get(dao.getPreferredClubNum(userId)-1);
				Thread.sleep(800);
				System.out.println("-------------------------------\n"
					+ Coloring.getGreen("로그인 성공, " + userId + "번 회원님, 환영합니다.") 
					+  "\n선호하는 구단: " + preferred.name + "\n\n\n\n\n\n\n");
				break;
				// 로그인 정보가 없다면, 선호하는 구단을 등록하기.
			} else { 
				Coloring.redOut("유저 정보가 존재하지 않습니다. 선호 구단 정보를 등록해주세요.");
				Thread.sleep(1000);
				int clubId = UserDAO.receivePreferredClubNum();
				Thread.sleep(700);
				dao.registerNewUser(userId, clubId);
				canLogin = true;
			}
		}
	}

	public static void changePreferredClub() throws IOException, InterruptedException {
		UserDAO dao = new UserDAO();
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		Coloring.greenOut("현재 등록된 선호구단: " + dao.getPreferredClubName(User.id));
		Thread.sleep(1000);
		//
		Coloring.cyanOut("정말로 선호 구단을 변경하시겠습니까? (Y/N)");
		while(true) {
			System.out.print(">>>");
			String userAnswer = rd.readLine().toLowerCase();
			if(userAnswer.equals("y")) {
				dao.changePreferredClub(UserDAO.receivePreferredClubNum());
				Thread.sleep(1500);
				ConsoleUtil.showCommand();
				break;
			} else if(userAnswer.equals("n")) {
				Coloring.purpleOut("선호구단을 변경하지 못했습니다. 메인 페이지로 이동합니다.");				
				Thread.sleep(1000);
				ConsoleUtil.showCommand();
				break;
			} else {
				Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
			}
		}
	}
}









