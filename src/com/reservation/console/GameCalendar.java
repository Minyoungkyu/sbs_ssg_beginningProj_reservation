package com.reservation.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.reservation.data.user.User;

public class GameCalendar {
		public static String[] home_game = new String[11];
		public static String[] away_game = new String[11];
		public static HashMap<Integer, String> day_schedule_club = new HashMap<>();
		public static HashMap<Integer, String> day_schedule_time = new HashMap<>();
		static {
			home_game[0] = ("         ");
			home_game[1] = Coloring.getCyan("   SSG   ");
			home_game[2] = Coloring.getCyan(" KIWOOM  ");
			home_game[3] = Coloring.getCyan("   LG    ");
			home_game[4] = Coloring.getCyan("   KT    ");
			home_game[5] = Coloring.getCyan("   KIA   ");
			home_game[6] = Coloring.getCyan("   NC    ");
			home_game[7] = Coloring.getCyan(" SAMSUNG ");
			home_game[8] = Coloring.getCyan("  LOTTE  ");
			home_game[9] = Coloring.getCyan(" DOOSAN  ");
			home_game[10] = Coloring.getCyan(" HANWHA  ");
			///////////
			away_game[0] = ("         ");
			away_game[1] = ("   SSG   ");
			away_game[2] = (" KIWOOM  ");
			away_game[3] = ("   LG    ");
			away_game[4] = ("   KT    ");
			away_game[5] = ("   KIA   ");
			away_game[6] = ("   NC    ");
			away_game[7] = (" SAMSUNG ");
			away_game[8] = ("  LOTTE  ");
			away_game[9] = (" DOOSAN  ");
			away_game[10] = (" HANWHA  ");
			
			for(int i = 1; i<32; i++){
				day_schedule_club.put(i, away_game[0]);
				day_schedule_time.put(i, away_game[0]);
			}
		}

		public static HashMap<Integer, Integer> showCalendar() {
			GameCalendarDAO dao = new GameCalendarDAO();
			HashMap<Integer, Integer> game_id_map = dao.loadSchedule();
			
			String calendar = String.format(""
				+ "=====================================================================\n"
				+ "   SUN   |   MON   |   TUE   |   WED   |   THU   |   FRI   |   SAT\n"
				+ "---------------------------------------------------------------------\n"
				+ "         |         |  1      |  2      |  3      |  4      |  5    \n"
				+ "         |         |%s|%s|%s|%s|%s\n"
				+ "         |         |%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  6      |  7      |  8      |  9      |  10     |  11     |  12   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  13     |  14     |  15     |  16     |  17     |  18     |  19   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  20     |  21     |  22     |  23     |  24     |  25     |  26   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  27     |  28     |  29     |  30     |  31     |         |       \n"
				+ "%s|%s|%s|%s|%s|         |         \n"
				+ "%s|%s|%s|%s|%s|         |         \n",
				day_schedule_club.get(1), 
				day_schedule_club.get(2),
				day_schedule_club.get(3),
				day_schedule_club.get(4),
				day_schedule_club.get(5),
				
				day_schedule_time.get(1),
				day_schedule_time.get(2),
				day_schedule_time.get(3),
				day_schedule_time.get(4),
				day_schedule_time.get(5),
				
				day_schedule_club.get(6),
				day_schedule_club.get(7),
				day_schedule_club.get(8),
				day_schedule_club.get(9),
				day_schedule_club.get(10),
				day_schedule_club.get(11),
				day_schedule_club.get(12),

				day_schedule_time.get(6),
				day_schedule_time.get(7),
				day_schedule_time.get(8),
				day_schedule_time.get(9),
				day_schedule_time.get(10),
				day_schedule_time.get(11),
				day_schedule_time.get(12),
				
				day_schedule_club.get(13),
				day_schedule_club.get(14),
				day_schedule_club.get(15),
				day_schedule_club.get(16),
				day_schedule_club.get(17),
				day_schedule_club.get(18),
				day_schedule_club.get(19),
				
				day_schedule_time.get(13),
				day_schedule_time.get(14),
				day_schedule_time.get(15),
				day_schedule_time.get(16),
				day_schedule_time.get(17),
				day_schedule_time.get(18),
				day_schedule_time.get(19),
				
				
				
				
				
				
				day_schedule_club.get(20),
				day_schedule_club.get(21),
				day_schedule_club.get(22),
				day_schedule_club.get(23),
				day_schedule_club.get(24),
				day_schedule_club.get(25),
				day_schedule_club.get(26),
				
				day_schedule_time.get(20),
				day_schedule_time.get(21),
				day_schedule_time.get(22),
				day_schedule_time.get(23),
				day_schedule_time.get(24),
				day_schedule_time.get(25),
				day_schedule_time.get(26),
				
				
				
				
				
				
				day_schedule_club.get(27),
				day_schedule_club.get(28),
				day_schedule_club.get(29),
				day_schedule_club.get(30),
				day_schedule_club.get(31),
				
				day_schedule_time.get(27),
				day_schedule_time.get(28),
				day_schedule_time.get(29),
				day_schedule_time.get(30),
				day_schedule_time.get(31)
				);
			System.out.println(calendar);
			return game_id_map;
		}
}

class GameCalendarDAO {
	Connection con;
	Statement state;
	ResultSet rs;
	
	public GameCalendarDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/reservation";
			con = DriverManager.getConnection(url, "root", "qkqh134679258");
			state = con.createStatement();
		} catch(Exception e) {
			Coloring.redOut("DB connection Exception: " + e.getMessage());
		}
	}
	
	public HashMap<Integer, Integer> loadSchedule() {
		try {
			HashMap<Integer, Integer> game_id_map = new HashMap<>();
			rs = state.executeQuery(SQL.select_preferred_games_SQL);
			while(rs.next()){
				String time = rs.getString(4).substring(11, 16).replace(":", "시 ") + "분 ";
				int day = Integer.parseInt((rs.getString(4).substring(8, 9).equals("0") ? rs.getString(4).substring(9, 10) : rs.getString(4).substring(8, 10)));
				int opponent_club_num = (rs.getInt(12) == User.preferredClub.clubNum ? rs.getInt(13) : rs.getInt(12) + 100);
				// 홈 경기인 경우, 100을 더해서 홈 경기임을 표시.
				
				// 홈 경기인 경우.
				if(opponent_club_num > 100){
					opponent_club_num -= 100;
					GameCalendar.day_schedule_club.put(day, GameCalendar.home_game[opponent_club_num]);
					GameCalendar.day_schedule_time.put(day, time);
				
				// 어웨이 경기인 경우.
				} else {
					GameCalendar.day_schedule_club.put(day, GameCalendar.away_game[opponent_club_num]);
					GameCalendar.day_schedule_time.put(day, time);
				}
				game_id_map.put(day, rs.getInt(1));
			}
			return game_id_map;
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}





