package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * �۾�����
 * 1. ����̹� �ε�
 */
public class DBTestMain {

	public static void main(String[] args) {

		try {
//			1�ܰ�: ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� �Ϸ�...");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.119.119:1521:dink",
					"scott",
					"tiger");
			System.out.println("DB���Ӽ���: "+ conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}