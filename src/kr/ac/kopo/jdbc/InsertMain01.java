package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// id: 'hong' name: 'ȫ�浿'���ڵ� ����

/*
 * �۾�����
 * 1. ����̹� �ε�
 * 2. DB ���� �� Connection ������
 * 3. sql ���� ��ü ������
 * 4. ���� ���� �� ��� ������
 * 5. ���� ����
 */

public class InsertMain01 {

	public static void main(String[] args) {

//		finally�� ���ֱ� ���� �ۿ� ������ ����
		Connection conn = null;
		Statement stmt = null;
		
//		1�ܰ�: ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����....");

//		2�ܰ�: DB ���� �� Connection ��ü ���
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB���Ӽ���: " + conn);

//		3�ܰ�: sql ���ఴü ������
			stmt = conn.createStatement();
			String sql = "insert into t_test(id, name) values('hong', 'ȫ�浿')";

//		4�ܰ�: sql ���� �� ��� ������
			int cnt = stmt.executeUpdate(sql); // return ���� int ������ ����
//			�ڵ����� commit���� ��
			System.out.println("�� " + cnt + "���� ���� ���ԵǾ����ϴ�");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

//		5�ܰ�: �������� (���� 2���� ��ü�� ���� connection�� statement ���ఴü ������� �������� ������ �����Ѵ�.)
			if(stmt != null) {
				try {					
					stmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn !=null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
//		�� ���� ���� �� �� why? �ϳ��� ���� ���ٰ� ���� ����ó���� ������ �� �Ǳ� ����
			
		}

	}
}
