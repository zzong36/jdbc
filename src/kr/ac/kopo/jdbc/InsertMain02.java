package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * ���̵� �Է�: park
 * �̸� �Է�: �ڱ浿
 * 1�� ���� ����
 */

public class InsertMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
			System.out.print("DB�� �Է��� ���̵�: ");
			String id = sc.nextLine();
			System.out.print("DB�� �Է��� �̸�:");
			String name = sc.nextLine();
			String sql = "insert into t_test(id, name) values(\'" + id + "\', \'" + name + "\')";

//		4�ܰ�: sql ���� �� ��� ������
			int cnt = stmt.executeUpdate(sql); // return ���� int ������ ����
//			�ڵ����� commit���� ��
			System.out.println("�� " + cnt + "���� ���� ���ԵǾ����ϴ�");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

//		5�ܰ�: �������� (���� 2���� ��ü�� ���� connection�� statement ���ఴü ������� �������� ������ �����Ѵ�.)
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
//		�� ���� ���� �� �� why? �ϳ��� ���� ���ٰ� ���� ����ó���� ������ �� �Ǳ� ����

		}

	}

}
