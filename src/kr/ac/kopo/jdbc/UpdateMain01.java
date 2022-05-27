package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class UpdateMain01 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
//			자동 커밋을 꺼주는 기능(보통은 쓸 이유가 없음 but 계좌이체의 경우에 사용할 수도 있음)
//			conn.setAutoCommit(false);

			Scanner sc = new Scanner(System.in);

			System.out.print("검색할 ID를 입력: ");
			String id = sc.nextLine();
			System.out.print("수정할 이름 입력: ");
			String name = sc.nextLine();

//			String sql = "update t_test ";
//			sql += " set name = ? ";
//			sql += " where id = ? ";

//			성능개선을 위해 String이 아닌 StringBuilder 사용
			StringBuilder sql = new StringBuilder();
			sql.append("update t_test ");
			sql.append(" set name = ? ");
			sql.append(" where id = ? ");
			
//			StringBuilder 객체를 .toString을 통해 String 형태로 변환한다.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, id);

			int cnt = pstmt.executeUpdate();
//			conn.commit();
			System.out.println(cnt + "행 수정완료...");

		} catch (Exception e) {
			JDBCClose.close(pstmt, conn);

		}

	}
}
