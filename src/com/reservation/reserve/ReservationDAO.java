package com.reservation.reserve;

import java.sql.*;
import com.reservation.console.ColorText;
import com.reservation.myreserve.MyreserveDAO;
import com.reservation.user.User;

public class ReservationDAO {
	//field
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

	public void showGameList() throws SQLException {
		String sql = "SELECT *, DAYOFWEEK(dateAndTime) As part \n"
			+ "FROM reservation.games ORDER BY dateAndTime ASC;";
		ResultSet rs = state.executeQuery(sql);
		System.out.println("--------------------------------------------------------------------------------------");
		while(rs.next()) {
			String name = ColorText.cyan + rs.getString(2) + ColorText.exit;
			String stadium = ColorText.yellow + rs.getString(3) + ColorText.exit;
			String dateAndTime = rs.getString(4);
			System.out.printf("게임번호: %d | %-20s | 경기장: %-12s | %s \n", rs.getInt(1), name, stadium, String.valueOf(MyreserveDAO.trimDateAndTime(dateAndTime, MyreserveDAO.getDayOfWeek(rs.getInt(11)))));
			System.out
				.println("--------------------------------------------------------------------------------------");
		}
	}
	
	public void showSeatList(int game_id) throws SQLException {
		String sql = "SELECT * FROM reservation.games WHERE id = " + game_id;
		ResultSet rs = state.executeQuery(sql);
		rs.next();
		String seatList = ColorText.purple
			+ "-------------------------------------------\n"
			+ "PREMIUM석: 최고의 자리, 후회없는 경기 직관\n"
			+ ColorText.exit
			+ filterZero(rs.getString(5))
			+ ColorText.yellow
			+ "-------------------------------------------\n"
			+ "TABLE석: 편안한 테이블과 함께 입이 즐거운 관람\n"
			+ ColorText.exit
			+ filterZero(rs.getString(6))
			+ ColorText.blue
			+ "-------------------------------------------\n"
			+ "BLUE석: 쾌적한 자리, 중앙에서 외야를 조망\n"
			+ ColorText.exit
			+ filterZero(rs.getString(7))
			+ ColorText.red
			+ "-------------------------------------------\n"
			+ "RED석: 일반석, 합리적인 가격에 경기를 관람\n"
			+ ColorText.exit
			+ filterZero(rs.getString(8))
			+ ColorText.cyan
			+ "-------------------------------------------\n"
			+ "NAVY석: 안락한 위층에서 경기를 한눈에 조망\n"
			+ ColorText.exit
			+ filterZero(rs.getString(9))
			+ ColorText.green
			+ "-------------------------------------------\n"
			+ "GREEN석: 가족과 함께 경기를 즐기고 홈런볼의 주인이 되세요!\n"
			+ ColorText.exit
			+ filterZero(rs.getString(10))
			+ "-------------------------------------------\n";
		System.out.print(seatList);
	}
	
	public String filterZero(String numOfSeat) {
		try {
			if(Integer.parseInt(numOfSeat) != 0){
				return "예매 가능한 좌석: " + numOfSeat + "석\n";			
			} else {
				return "예약 가능한 좌석이 없습니다.\n";
			}
		} catch(Exception e) {
			return "예약 가능한 좌석이 없습니다.\n";
		}
	}
	public void showSeatBlock(String seatType) throws SQLException {
		try {
			String sql = String.format("SELECT seatBlockScope FROM reservation.seats WHERE seatType = '%s'",seatType);
			ResultSet rs = state.executeQuery(sql);
			StringBuilder blockScope = new StringBuilder();
			while(rs.next()){
				String[] tem1 = rs.getString(1).split(", ");
				for(String scope: tem1){
					blockScope.append("\n| ");
					int startBlock = Integer.parseInt(scope.substring(0, scope.indexOf("~")).trim()); // 앞 번호
					int endBlock = Integer.parseInt(scope.substring(scope.indexOf("~") +1).trim()); // 뒷 번호
					while(startBlock <= endBlock){
						blockScope.append(startBlock + " | ");
						startBlock++;
					}
				}
			}
			ColorText.greenOut(seatType + "석에서 예매 가능한 블럭목록입니다." + blockScope);
		} catch(NullPointerException NPE) {
			ColorText.greenOut("\n" + seatType + "석은 단일 블록 좌석입니다. 자동으로 블록이 선택됩니다.");			
		}
	}
	
	public void selectSeat(int game_id, String seatType, int seatBlock){
		String addReservationSQL = String.format(
			"INSERT INTO reservation.reservations (gameID, seatType, seatBlock, userID) "
			+ "VALUES (%d, '%s', %d, %d)", game_id, seatType, seatBlock, User.getID());
		String updateGameInfoSQL = String.format(
			"UPDATE reservation.games\n"
			+ "SET %s = %s - 1\n"
			+ "WHERE id = %d;", seatType, seatType, game_id);
		try {
			state.executeUpdate(addReservationSQL);
			state.executeUpdate(updateGameInfoSQL);
		} catch(SQLException e) {
			ColorText.redOut("쿼리 전달 실패: "+ e);
		}
	}

}


















