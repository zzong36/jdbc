package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 작업순서
 * 1. 드라이버 로딩
 */
public class DBTestMain {

	public static void main(String[] args) {

		try {
//			1단계: 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료...");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.119.119:1521:dink",
					"scott",
					"tiger");
			System.out.println("DB접속성공: "+ conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}