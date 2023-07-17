package com.reservation.data.club;

import java.util.ArrayList;

import com.reservation.console.Coloring;

public enum Club {
	SSG(1, "SSG 랜더스", "인천 SSG 랜더스필드"),
	KIWOOM(2, "키움 히어로즈", "고척 스카이돔"),
	LG(3, "LG 트윈스", "서울종합운동장 야구장"),
	KT(4, "KT wiz", "수원 케이티 위즈 파크"),
	KIA(5, "KIA 타이거즈", "광주-기아 챔피언스 필드"),
	NC(6, "NC 다이노스", "창원 NC 파크"),
	SAMSUNG(7, "삼성 라이온즈", "대구 삼성 라이온즈 파크"),
	LOTTE(8, "롯데 자이언츠", "사직 야구장"),
	DOOSAN(9, "두산 베어스", "서울종합운동장 야구장"),
	HANWHA(10, "한화 이글스", "대전 한화생명 이글스파크");
	public static ArrayList<Club> clubs = new ArrayList<>();
	public int clubNum;
	public String name;
	public String home;
	
	
	Club(int clubNum, String name, String home){
		this.clubNum = clubNum;
		this.name = name;
		this.home = home;
	}
	
	static {
		clubs.add(SSG);
		clubs.add(KIWOOM);
		clubs.add(LG);
		clubs.add(KT);
		clubs.add(KIA);
		clubs.add(NC);
		clubs.add(SAMSUNG);
		clubs.add(LOTTE);
		clubs.add(DOOSAN);
		clubs.add(HANWHA);	
	}
	
	public static String clubList = 
		  "------------------\n"
		+ Coloring.getCyan("SSG 랜더스: 	1\n")
		+ "------------------\n"
		+ Coloring.getCyan("키움 히어로즈: 	2\n")
		+ "------------------\n"
		+ Coloring.getCyan("LG 트윈스: 	3\n")
		+ "------------------\n"
		+ Coloring.getCyan("KT wiz:		4\n")
		+ "------------------\n"
		+ Coloring.getCyan("KIA 타이거즈: 	5\n")
		+ "------------------\n"
		+ Coloring.getCyan("NC 다이노스: 	6\n")
		+ "------------------\n"
		+ Coloring.getCyan("삼성 라이온즈:	7\n")
		+ "------------------\n"
		+ Coloring.getCyan("롯데 자이언츠:	8\n")
		+ "------------------\n"
		+ Coloring.getCyan("두산 베어스:	9\n")
		+ "------------------\n"
		+ Coloring.getCyan("한화 이글스:	10\n")
		+ "------------------";
	
	public static Club getClubByNum(int clubNum) {
		switch(clubNum){
		case 1:
			return SSG;
		case 2:
			return KIWOOM;
		case 3:
			return LG;
		case 4:
			return KT;
		case 5:
			return KIA;
		case 6:
			return NC;
		case 7:
			return SAMSUNG;
		case 8:
			return LOTTE;
		case 9:
			return DOOSAN;
		case 10:
			return HANWHA;
		default:
			return null;
		}
	}
}
