package edu.jdbcsecond;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExSecond {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=Asia/Seoul",
					"root", "pw");
			
			if (conn != null) System.out.println("연결 성공");
			
		
			
			String[] ts = {"name",
					"userName",
					"birthYear",
					"addr",
					"mobile1",
					"mobile2",
					"height",
					"mDate"};
			
			Statement statement = conn.createStatement();
			String[] ts2 = {"name", "id", "dept"};
			System.out.println("출력");
			//statement.executeUpdate("delete from student where id='강호동'");
			//statement.executeUpdate("insert into student values('강호동', '기계공학', '3333333')");
			//statement.executeUpdate("insert into student values('유재석', '연극영화과', '5555555')");
			//statement.executeUpdate("update student set dept='체육학과' where id='3333333'");
			//statement.executeUpdate("delete from student where id='5555555'");
			statement.executeUpdate("insert into student values('유재석', '연극영화과', '5555555')");
			statement.executeUpdate("update student set dept='국어국문' where id='3333333'");
			printData(statement.executeQuery("select * from student"), ts2);
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

	private static void printData(ResultSet s, String[] x) throws SQLException {
		for(String a:x) System.out.printf("\t%s\t|", a);
		System.out.println();
		while (s.next()) {
			for(String a:x) System.out.printf("\t%s\t|", s.getString(a));
			System.out.println();
		}
	}
}