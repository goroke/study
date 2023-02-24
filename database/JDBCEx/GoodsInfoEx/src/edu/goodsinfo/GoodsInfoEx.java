package edu.goodsinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodsInfoEx {

	private static void printData(ResultSet s, String x) throws SQLException {
		int c = 0;
		for(String a:x.split(" ")) System.out.printf("%s%-25s", (c++>0?"|":""), a);
		System.out.println();
		
		while (s.next()) {
			c = 0;
			for(String a:x.split(" ")) {
				if(c++>0) System.out.print("|");
				System.out.printf("%-25s", s.getString(a));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "pw");
			Statement  statement = conn.createStatement();

			
			//statement.executeUpdate("insert into book values(0, 'Potter', 'Bloomsbury', 'J. K. Rowling')");
			//statement.executeUpdate("insert into book values(1, 'The Lord of the Rings', 'Allen & Unwin', 'J. R. R. Tolkein')");
			//statement.executeUpdate("insert into book values(2, 'Pride and Prejudice', 'T. Egerton Kingdom', 'Jane Austen')");
			//statement.executeUpdate("insert into book values(2, 'Pride and Prejudice', 'T. Egerton Kingdom', 'Jane Austen')");
			
			printData(statement.executeQuery("select * from goodsinfo"), "code name price maker");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


// select
// insert 알아서 넣어볼 것
// avg, sum, count
// groupby, having(avg(price)>=300000) << 데이터를 넣어야 정상 작동할 예정
