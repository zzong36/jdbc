package kr.ac.kopo.jdbc;

import java.util.Scanner;

public class practice {

	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("DB�� �Է��� ���̵�: ");
//		String id = sc.nextLine();
//		System.out.println("DB�� �Է��� �̸�:");
//		String name = sc.nextLine();
//		String sql = "insert into t_test(id, name) values('" + id + "', '" + name + "')";
//		System.out.println(sql);
		
		double profit = 1;
		for(int i = 0; i<9; i++) {
			profit=profit*1.08;
		}
		
		System.out.println(profit);
	}
}
