package com.reservation.reserve;

import java.sql.*;
import com.reservation.console.ColorText;

public class ReservationDAO {
	Connection con;
	Statement state;
	public ReservationDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/?user=root";
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			ColorText.redOut("DB connection Exception: " + e.getMessage());
		}
	}

	public void showGameList() throws SQLException{
		String sql = "SELECT * FROM reservation.games ORDER BY dateAndTime ASC;";
		ResultSet rs = state.executeQuery(sql);
		System.out.println("--------------------------------------------------------------------------------------");
		while(rs.next()){
			String name = ColorText.cyan + rs.getString(2) + ColorText.exit;
			String stadium = ColorText.yellow + rs.getString(3) + ColorText.exit;
			String dateAndTime = rs.getString(4);
			System.out.printf("게임번호: %d | %-20s | 경기장: %-12s | %s \n", rs.getInt(1), name, stadium, dateAndTime);
			System.out.println("--------------------------------------------------------------------------------------");
		}
	}

	public void showSeatList(int game_id) throws SQLException {
		String sql = "SELECT * FROM reservation.game_seat WHERE game_id = " + game_id;
		ResultSet rs = state.executeQuery(sql);
		rs.next();
		String seatList = ColorText.purple
			  + "-------------------------------------------\n"
			  + "PRIMIIM석: 최고의 자리, 후회없는 경기 직관\n"
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(2) + "석\n"
			  + ColorText.yellow 
			  +	"-------------------------------------------\n"
			  +	"TABLE석: 편안한 테이블과 함께 입이 즐거운 관람\n"
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(3) + "석\n"
			  + ColorText.blue 
			  +	"-------------------------------------------\n"
			  +	"BLUE석: 쾌적한 자리, 중앙에서 외야를 조망\n"
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(4) + "석\n"
			  + ColorText.red
			  +	"-------------------------------------------\n"
			  + "RED석: 일반석, 합리적인 가격에 경기를 관람\n"
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(5) + "석\n"
			  + ColorText.cyan
			  +	"-------------------------------------------\n"										  
			  +	"NAVY석: 안락한 위층에서 경기를 한눈에 조망\n" 
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(6) + "석\n"
			  + ColorText.green
			  +	"-------------------------------------------\n"										  
			  +	"GREEN석: 가족과 함께 경기를 즐기고 홈런볼의 주인이 되세요!\n" 
			  + ColorText.exit
			  + "예매 가능한 좌석: " + rs.getString(7) + "석\n"
			  +	"-------------------------------------------\n";									  
		System.out.print(seatList);
	}
	public void selectSeat(int game_id, String seat) throws SQLException {
		String sql = "SELECT * FROM reservation.games ORDER BY `dateAndTime` ASC;";
		ResultSet rs = state.executeQuery(sql);
	}
}
