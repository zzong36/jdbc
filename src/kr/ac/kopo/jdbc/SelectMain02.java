package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class SelectMain02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

//			아래처럼 간단하게 실행 가능
			conn = new ConnectionFactory().getConnection();
			
//			실행시킬 쿼리문 작성
			String sql = "select * from t_test";
			pstmt = conn.prepareStatement(sql);

//			실행문(select는 executeQuery 사용)
			ResultSet rs = pstmt.executeQuery();

//			rs는 커서일뿐 내가 조회하려는 레코드 수는 알 수 없다. 그러므로 rs.next()를 사용해서 더 이상 가리키는 곳이 없을 때까지 데이터를 가져온다.
			while (rs.next() != false) {
//				rs.next()로 사용가능한가? getString()의 의미는 String의 형태로 가져오겠다는 뜻인가?
				String id = rs.getString("id");
				String name = rs.getString("name");

				System.out.println("id: " + id + " name: " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			close 객체 사용
			JDBCClose.close(pstmt, conn);
		}
	}

}
