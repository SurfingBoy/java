package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JDBCTest {
	public static void main(String[] args) {
		getAll("20");
	}

private static Connection getConn() {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="123456";
	Connection conn=null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return conn;
}

private static int Insert(String name,int age) {
	Connection conn=getConn();
	int i=0;
	String sql="insert into users(Name,Age) values(?,?)";
	PreparedStatement pstms;
	try {
		pstms=(PreparedStatement) conn.prepareStatement(sql);
		pstms.setString(1, name);
		pstms.setInt(2, age);
		i=pstms.executeUpdate();
		pstms.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}

private static int getAll(String age) {
	Connection conn=getConn();
	String sql="select *from users where Age< ?";
	PreparedStatement pstms;
	try {
		pstms=(PreparedStatement) conn.prepareStatement(sql);
		pstms.setString(1, age);
		ResultSet rs=pstms.executeQuery();
		int columnIndex=rs.getMetaData().getColumnCount();
		while(rs.next()) {
			for(int i=1;i<=columnIndex;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println("");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 1;
}
}