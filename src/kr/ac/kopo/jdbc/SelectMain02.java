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

//			�Ʒ�ó�� �����ϰ� ���� ����
			conn = new ConnectionFactory().getConnection();
			
//			�����ų ������ �ۼ�
			String sql = "select * from t_test";
			pstmt = conn.prepareStatement(sql);

//			���๮(select�� executeQuery ���)
			ResultSet rs = pstmt.executeQuery();

//			rs�� Ŀ���ϻ� ���� ��ȸ�Ϸ��� ���ڵ� ���� �� �� ����. �׷��Ƿ� rs.next()�� ����ؼ� �� �̻� ����Ű�� ���� ���� ������ �����͸� �����´�.
			while (rs.next() != false) {
//				rs.next()�� ��밡���Ѱ�? getString()�� �ǹ̴� String�� ���·� �������ڴٴ� ���ΰ�?
				String id = rs.getString("id");
				String name = rs.getString("name");

				System.out.println("id: " + id + " name: " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			close ��ü ���
			JDBCClose.close(pstmt, conn);
		}
	}

}
