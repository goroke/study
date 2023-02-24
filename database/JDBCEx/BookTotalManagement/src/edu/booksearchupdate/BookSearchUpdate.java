package edu.booksearchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookSearchUpdate {
	
	private static void printData(ResultSet s, String x, String length) throws SQLException {
		int c = 0;
		String[] titles=x.split(" "), lengthArray=length.split(" ");
		for(c=0;c<titles.length;) {System.out.printf("%s%"+lengthArray[c]+"s", (c>0?"|":""), titles[c]); c++;}
		System.out.println();
		
		while (s.next()) {
			c = 0;
			for(String a:x.split(" ")) {
				if(c>0) System.out.print("|");
				System.out.printf("%"+lengthArray[c++]+"s", s.getString(a));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		try{Class.forName("com.mysql.cj.jdbc.Driver");}
		catch(ClassNotFoundException e) {System.out.println("드라이버 로드 실패");}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "pw");
		} catch (SQLException e) {System.out.println("데이터베이스 로드 실패");}

		
		try {
			Statement  statement = conn.createStatement();
			
			System.out.println("<현재 데이터>");
			printData(statement.executeQuery("select * from book"), "id title publisher author", "4 -30 -30 -10");
			
			System.out.print("동작을 선택하세요. (1: 검색), (2: 삽입), (3: 편집), (4: 삭제)\n입력: ");
			String q = sc.nextLine();
			
			switch (q) {
			case "1":
				StringBuilder sb = new StringBuilder("select * from book where"),
							  tb = new StringBuilder();
				
				ResultSet s = statement.executeQuery("select column_name "+
													 "from information_schema.columns "+
									   				 "where table_name = 'book';");
				while (s.next()) {tb.append(s.getString(0)); if (!s.isLast()) tb.append(' ');}
				
				System.out.print("키워드를 입력하세요: ");
				String search = sc.nextLine();
				
				for (String x: tb.toString().split(search)) {
					sb.append(' ').append(x).append("=").append(search)
					.append(" or");	// 여기 만들다 만 부분
				}
				
				printData(statement.executeQuery(sb.toString()), "id title publisher author", "4 -30 -30 -10");
				break;
			case "2":
				System.out.println("서비스 준비 중 ^^;");
				break;
			case "3":
			}
			sc.close();
		} catch (SQLException e) {System.out.println("에러 발생");}
	}
}
