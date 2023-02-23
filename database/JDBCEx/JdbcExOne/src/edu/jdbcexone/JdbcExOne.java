package edu.jdbcexone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExOne {
	
	private static void printData(ResultSet s, String[] x) throws SQLException {
		while (s.next()) {
			for(String a:x) System.out.printf("\t%s\t|", s.getString(a));
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("JDBC Start");
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=Asia/Seoul",
					"root", "pw");
			
			if (conn != null) System.out.println("연결 성공");
			
			Statement statement = conn.createStatement();
			//statement.executeUpdate("insert into student values()");
			
/*			String[] ts = {"name",
							"userName",
							"birthYear",
							"addr",
							"mobile1",
							"mobile2",
							"height",
							"mDate"}; */
			
			String[] ts = {"id", "dept", "name"};
			System.out.println("전부 출력");
			printData(statement.executeQuery("select * from student"), ts);
			System.out.println("특정 레코드만 검색");
			printData(statement.executeQuery("select * from student where name='최고봉'"), ts);
			
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
		}
		
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		finally {
			try {
				conn.close();
				System.out.println("연결을 해제합니다.");
			}
			catch (Exception e) {e.getStackTrace();}
		}
		
	}
}
