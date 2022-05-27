package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";

//			DB���� �����͸� �����´�
			conn = DriverManager.getConnection(url, user, password);

//			�����ų ������ �ۼ�
			String sql = "select * from t_test";
			pstmt = conn.prepareStatement(sql);

//			���๮(select�� executeQuery ���)
			ResultSet rs = pstmt.executeQuery();

//			rs�� Ŀ���ϻ� ���� ��ȸ�Ϸ��� ���ڵ� ���� �� �� ����. �׷��Ƿ� rs.next()�� ����ؼ� �� �̻� ����Ű�� ���� ���� ������ �����͸� �����´�.
			while (rs.next()) {
//				rs.next()�� ��밡���Ѱ�? getString()�� �ǹ̴� String�� ���·� �������ڴٴ� ���ΰ�?
				String id = rs.getString("id");
				String name = rs.getString("name");

				System.out.println("id: " + id + " name: " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			connection�� �ݴ� ������? close()�� ������ ������ ������� �ʴ� ������ �����Ǿ� DB �ڿ��� �����ϰ� �ȴ�. 
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
