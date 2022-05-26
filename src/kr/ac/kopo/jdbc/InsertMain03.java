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
			String name = "�Ա浿";
			
			String sql = "insert into t_test(id, name) values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
//			����ǥ�� ä�� ����
			pstmt.setString(1, id); //�˾Ƽ� ���� ����ǥ�� ����(���� ����ǥ�� ��ġ�� �����Ƽ� �׷���)
			pstmt.setString(2, name); //�˾Ƽ� ���� ����ǥ�� ����(���� ����ǥ�� ��ġ�� �����Ƽ� �׷���)
			
			int cnt = pstmt.executeUpdate(); // return ���� int ������ ����
//			�ڵ����� commit���� ��
			System.out.println("�� " + cnt + "���� ���� ���ԵǾ����ϴ�");

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
