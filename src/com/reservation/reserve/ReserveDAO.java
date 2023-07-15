package com.reservation.reserve;

import java.sql.*;
import java.util.HashSet;

import com.reservation.console.Coloring;
import com.reservation.data.user.User;
import com.reservation.myreserve.MyreserveDAO;

public class ReserveDAO {
	Connection con;
	Statement state;

	public ReserveDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/?user=root";
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			Coloring.redOut("DB connection Exception: " + e.getMessage());
		}
	}

	public void showGameList() {
		String loadGamesSQL = "SELECT *, DAYOFWEEK(dateAndTime) As part \n"
			+ "FROM reservation.games ORDER BY dateAndTime ASC;";
		try {
			ResultSet rs = state.executeQuery(loadGamesSQL);
			System.out
				.println("--------------------------------------------------------------------------------------");
			while(rs.next()) {
				String name = Coloring.cyan + rs.getString(2) + Coloring.exit;
				String stadium = Coloring.yellow + rs.getString(3) + Coloring.exit;
				String dateAndTime = rs.getString(4);
				System.out.printf("게임번호: %d | %-20s | 경기장: %-12s | %s \n", rs.getInt(1), name, stadium, String
					.valueOf(MyreserveDAO.trimDateAndTime(dateAndTime, MyreserveDAO.getDayOfWeek(rs.getInt(11)))));
				System.out
					.println("--------------------------------------------------------------------------------------");
			}
			rs.close();
		} catch(SQLException e) {
			System.out.println("SQLException!: " + e);
		}
	}

	public void showSeatList(int game_id) {
		String loadSeatStatus = "SELECT *, DAYOFWEEK(dateAndTime) As part FROM reservation.games WHERE id = " + game_id;
		try {
			ResultSet rs = state.executeQuery(loadSeatStatus);
			rs.next();
			int[] priceData = loadPriceData(MyreserveDAO.getDayOfWeek(rs.getInt(11)));
			String seatList = Coloring.getPurple(
				"-------------------------------------------\n"
					+ "PREMIUM석: 최고의 자리, 후회없는 경기 직관\n")
				+ filterZero(rs.getString(5)) + " | 가격: " + priceData[0] + "\n"
				+ Coloring.getYellow(
					"-------------------------------------------\n"
						+ "TABLE석: 편안한 테이블과 함께 입이 즐거운 관람\n")
				+ filterZero(rs.getString(6)) + " | 가격: " + priceData[1] + "\n"
				+ Coloring.getBlue(
					"-------------------------------------------\n"
						+ "BLUE석: 쾌적한 자리, 중앙에서 외야를 조망\n")
				+ filterZero(rs.getString(7)) + " | 가격: " + priceData[2] + "\n"
				+ Coloring.getRed(
					"-------------------------------------------\n"
						+ "RED석: 일반석, 합리적인 가격에 경기를 관람\n")
				+ filterZero(rs.getString(8)) + " | 가격: " + priceData[3] + "\n"
				+ Coloring.getCyan(
					"-------------------------------------------\n"
						+ "NAVY석: 안락한 위층에서 경기를 한눈에 조망\n")
				+ filterZero(rs.getString(9)) + " | 가격: " + priceData[4] + "\n"
				+ Coloring.getGreen(
					"-------------------------------------------\n"
						+ "GREEN석: 가족과 함께 경기를 즐기고 홈런볼의 주인이 되세요!\n")
				+ filterZero(rs.getString(10)) + " | 가격: " + priceData[5] + "\n"
				+ "-------------------------------------------\n";
			System.out.print(seatList);
			rs.close();
		} catch(SQLException e) {
			System.out.println(e);
		} catch(Exception e){
			System.out.println(e);
		} 
	}

	public int[] loadPriceData(String dayOfWeek) throws SQLException {
		Statement st = con.createStatement();
		ResultSet priceData = st.executeQuery("SELECT * FROM reservation.seats ORDER BY weekdayPrice DESC");
		int[] price = new int[6];
		int ColumnNumberByDayOfWeek;
		if(dayOfWeek.equals("월요일") ||
			dayOfWeek.equals("화요일") ||
			dayOfWeek.equals("수요일") ||
			dayOfWeek.equals("목요일") ||
			dayOfWeek.equals("금요일")) {
			ColumnNumberByDayOfWeek = 3;
		} else {
			ColumnNumberByDayOfWeek = 4;
		}
		int i = 0;
		while(priceData.next()) {
			price[i] = priceData.getInt(ColumnNumberByDayOfWeek);
			i++;
		}
		priceData.close();
		return price;
	}

	public String filterZero(String numOfSeat) {
		try {
			if(Integer.parseInt(numOfSeat) != 0) {
				return "예매 가능한 좌석: " + numOfSeat + "석";
			} else {
				return "예약 가능한 좌석이 없습니다.";
			}
		} catch(Exception e) {
			return "예약 가능한 좌석이 없습니다.";
		}
	}

	public HashSet<Integer> showSeatBlock(String seatType) {
		try {
			HashSet<Integer> seatBlockSet  = new HashSet<>();
			String loadSeatBlockScopeSQL = String.format(
				"SELECT seatBlockScope FROM reservation.seats WHERE seatType = '%s'", seatType);
			ResultSet rs = state.executeQuery(loadSeatBlockScopeSQL);
			StringBuilder blockScope = new StringBuilder();
			while(rs.next()) {
				String[] tem1 = rs.getString(1).split(", ");
				for(String scope : tem1) {
					blockScope.append("\n| ");
					int startBlock = Integer.parseInt(scope.substring(0, scope.indexOf("~")).trim()); // 앞 번호
					int endBlock = Integer.parseInt(scope.substring(scope.indexOf("~") + 1).trim()); // 뒷 번호
					while(startBlock <= endBlock) {
						blockScope.append(startBlock + " | ");
						seatBlockSet.add(startBlock);
						startBlock++;
					}
				}
			}
			Coloring.greenOut(seatType + "석에서 예매 가능한 블럭목록입니다." + blockScope);
			rs.close();
			return seatBlockSet;
		} catch(NullPointerException NPE) { // premium석 선택한 경우.
			Coloring.greenOut("\n" + seatType + "석은 단일 블록 좌석입니다. 자동으로 블록이 선택됩니다.");
		} catch(SQLException e) {
			System.out.println("ReserveDAO.showSeatBlock method throw SQLE!");
		}
		return null;
	}

	public void selectSeat(int game_id, String seatType, int seatBlock) {
		String addReservationSQL = String.format(
			"INSERT INTO reservation.reservations (gameID, seatType, seatBlock, userID) "
				+ "VALUES (%d, '%s', %d, %d)",
			game_id, seatType, seatBlock, User.getID());
		String updateGameInfoSQL = String.format(
			"UPDATE reservation.games\n"
				+ "SET `%s` = `%s` - 1\n"
				+ "WHERE id = %d;",
			seatType, seatType, game_id);
		try {
			Statement st = con.createStatement();
			state.executeUpdate(addReservationSQL);
			st.executeUpdate(updateGameInfoSQL);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
}
