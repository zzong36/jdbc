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
//			자동 커밋을 꺼주는 기능
//			conn.setAutoCommit(false);

			Scanner sc = new Scanner(System.in);

			System.out.print("검색할 ID를 입력: ");
			String id = sc.nextLine();
			System.out.print("수정할 이름 입력: ");
			String name = sc.nextLine();

			String sql = "update t_test ";
			sql += " set name = ? ";
			sql += " where id = ? ";

			pstmt = conn.prepareStatement(sql);
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
