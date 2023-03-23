package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert2 {

	public static void main(String[] args) {
		// insert, update, delete 작업 시 두 개의 객체만 사용
		Connection con = null;
		PreparedStatement pre = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("부서번호 :");
			int deptno = sc.nextInt();
			System.out.println("부서명 : ");
			String dname = sc.next();
			System.out.println("지역 : ");
			String loc = sc.next();
			
			String sql = "insert into dept_temp (deptno,dname,loc)values (?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setInt(1, deptno);
			pre.setString(2, dname);
			pre.setString(3, loc);

			int count = pre.executeUpdate();
			if (count > 0) {
				System.out.println("입력 성공");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {try {
			pre.close();
			con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		}

	}

}
