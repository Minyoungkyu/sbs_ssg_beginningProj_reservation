package com.reservation.data.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import com.reservation.console.Coloring;
import com.reservation.console.ConsoleUtil;
import com.reservation.data.club.Club;
public class UserDAO {
	Connection con;
	Statement state;
	ResultSet rs;
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public UserDAO() {
		String url = "jdbc:mysql://localhost:3306/?user=root";
		try {
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public int getPreferredClubNum(int userId) {
		try {
			String loadPreferredClubNumSQL = "SELECT preferredClubNum FROM reservation.user WHERE id = " + userId;
			rs = state.executeQuery(loadPreferredClubNumSQL);
			rs.next();
			return rs.getInt(1);
		} catch(SQLException e) {
			return 0;			
		}
	}
	
	
	public String getPreferredClubName(int userId) {
		UserDAO dao = new UserDAO();
		return Club.clubs.get(dao.getPreferredClubNum(userId)-1).name;
	}
	
	
	public boolean checkUserRegistrationData(int userId) {
		try {
			String loadUserRegistrationSQL = "SELECT * FROM reservation.user WHERE id = " + userId;
			ResultSet checkSet= state.executeQuery(loadUserRegistrationSQL);
			///// ResultSet에 아무것도 없다면, 다음 두줄의 코드는 예외를 발생시킬 것.
			checkSet.next();
			checkSet.getInt(1);
			////
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public void registerNewUser(int userId, int clubId) {
		try {
			String registerNewUserSQL = String.format("INSERT INTO reservation.user VALUES (%d, '%s')", userId, clubId);
			state.executeUpdate(registerNewUserSQL);
			Coloring.greenOut("\n유저 등록 완료.");
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public static int receivePreferredClubNum() throws IOException{
		System.out.println(Club.clubList);
		Coloring.greenOut("선호하는 구단을 선택하여 주십시오.");
		System.out.print("구단 입력: ");
		int PreClubNum = ConsoleUtil.receiveCustomRangeNum(1, 10);
		return PreClubNum;
	}

	public void changePreferredClub(int newPreferredClub) {
		try {
			String changePreferredClubSQL = String.format(
				"UPDATE reservation.user\n"
				+ "SET preferredClubNum = %d\n"
				+ "WHERE id = %d", newPreferredClub, User.id);
			state.executeUpdate(changePreferredClubSQL);
			Coloring.greenOut("선호구단 정보 변경 완료.");
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
}





