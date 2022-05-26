package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMain03 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
		
			String id = "ham";
			String name = "함길동";
			
			String sql = "insert into t_test(id, name) values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
//			물음표를 채울 예정
			pstmt.setString(1, id); //알아서 작은 따옴표가 들어간다(작은 따옴표를 부치기 귀찮아서 그렇다)
			pstmt.setString(2, name); //알아서 작은 따옴표가 들어간다(작은 따옴표를 부치기 귀찮아서 그렇다)
			
			int cnt = pstmt.executeUpdate(); // return 값이 int 수정한 개수
//			자동으로 commit까지 됨
			System.out.println("총 " + cnt + "개의 행이 삽입되었습니다");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
		}
		
	}
}
