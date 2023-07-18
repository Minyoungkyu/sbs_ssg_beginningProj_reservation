package com.reservation.console;

import com.reservation.data.user.User;

public class SQL {
	public static String select_preferred_games_SQL = String.format(
		"SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM reservation.games WHERE name LIKE '%%%s%%' ORDER BY dateAndTime ASC",
		User.preferredClub.name);
	public static String select_all_games_SQL = "SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM reservation.games ORDER BY dateAndTime ASC";
}
