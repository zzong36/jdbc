package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 아이디 입력: park
 * 이름 입력: 박길동
 * 1개 행을 삽입
 */

public class InsertMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		finally에 써주기 위해 밖에 변수를 선언
		Connection conn = null;
		Statement stmt = null;

//		1단계: 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공....");

//		2단계: DB 접속 및 Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속성공: " + conn);

//		3단계: sql 실행객체 얻어오기
			stmt = conn.createStatement();
			System.out.print("DB에 입력할 아이디: ");
			String id = sc.nextLine();
			System.out.print("DB에 입력할 이릅:");
			String name = sc.nextLine();
			String sql = "insert into t_test(id, name) values(\'" + id + "\', \'" + name + "\')";

//		4단계: sql 실행 및 결과 얻어오기
			int cnt = stmt.executeUpdate(sql); // return 값이 int 수정한 개수
//			자동으로 commit까지 됨
			System.out.println("총 " + cnt + "개의 행이 삽입되었습니다");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

//		5단계: 접속종료 (현재 2개의 객체를 얻어옴 connection과 statement 실행객체 만들어진 역순으로 접속을 종료한다.)
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		한 번에 쓰면 안 됨 why? 하나가 에러 났다고 둘을 예외처리로 던지면 안 되기 때문

		}

	}

}
