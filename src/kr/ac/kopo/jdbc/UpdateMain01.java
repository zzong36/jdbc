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
//			�ڵ� Ŀ���� ���ִ� ���
//			conn.setAutoCommit(false);

			Scanner sc = new Scanner(System.in);

			System.out.print("�˻��� ID�� �Է�: ");
			String id = sc.nextLine();
			System.out.print("������ �̸� �Է�: ");
			String name = sc.nextLine();

			String sql = "update t_test ";
			sql += " set name = ? ";
			sql += " where id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);

			int cnt = pstmt.executeUpdate();
//			conn.commit();
			System.out.println(cnt + "�� �����Ϸ�...");

		} catch (Exception e) {
			JDBCClose.close(pstmt, conn);

		}

	}
}
