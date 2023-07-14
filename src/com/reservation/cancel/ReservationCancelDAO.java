package com.reservation.cancel;

import java.io.*;
import java.sql.*;

import com.reservation.console.ColorText;
import com.reservation.console.ConsoleUtil;
import com.reservation.myreserve.MyreserveDAO;
import com.reservation.reserve.ReservationServer;
import com.reservation.user.User;

public class ReservationCancelDAO {
	Connection con;
	Statement state;
	ResultSet rs;
	BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public ReservationCancelDAO() {
		String url = "jdbc:mysql://localhost:3306/?user=root";
		try {
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			e.getMessage();
		}
	}

	public void cancelReservation() throws NumberFormatException, IOException, SQLException {
		System.out.print("\n취소를 원하시는 예매의 예매번호를 입력하여 주십시오.\n>>>");
		int reservationID;
		while(true){
			try {
				reservationID = Integer.parseInt(rd.readLine());
				String cancelTargetReservationSelectSQL = 
					"SELECT reservationID,\n"
					+ " seatType,\n"
					+ " seatBlock,\n"
					+ " userID,\n"
					+ " name,\n"
					+ " stadium,\n"
					+ " dateAndTime,\n"
					+ " DAYOFWEEK(dateAndTime) As part \n"
					+ " FROM reservation.reservations\n"
					+ "JOIN reservation.games\n"
					+ "on gameID = id\n"
					+ "WHERE reservationID =" + reservationID;
				rs = state.executeQuery(cancelTargetReservationSelectSQL);
				System.out.println();
				rs.next();
				if(rs.getInt(4) != User.getID()){
					throw new Exception();
				}
				String gameName = rs.getString(5);
				String stadium = rs.getString(6);
				String DayOfWeek = MyreserveDAO.getDayOfWeek(rs.getInt(8));
				StringBuilder startWhen = MyreserveDAO.trimDateAndTime(rs.getString(7), DayOfWeek);
				String seatType = rs.getString(2);
				int seatBlock = rs.getInt(3);
				ColorText.purpleOut("정말로 다음의 예매를 취소하시겠습니까? (Y/N)");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.print("예매번호: " + reservationID + " | ");
				System.out.print(ColorText.cyan + gameName + ColorText.exit);
				System.out.print(" | ");
				System.out.print(ColorText.yellow + stadium + ColorText.exit);
				System.out.print(" | ");
				System.out.print(seatType+"석 " + seatBlock + "블록 ");
				System.out.print(" | ");
				System.out.print(startWhen);
				System.out.print("---------------------------------------------------------------------------------------\n");
				break;
			} catch(Exception e) {
				System.out.print(ColorText.red+"해당 번호로 조회한 예매가 존재하지 않습니다.\n" + ColorText.exit + "다시 입력해 주십시오.\n >>>");
			}
		}
		String cancelReservationSQL = "reservationID";
		state.executeQuery(cancelReservationSQL);

}

}
