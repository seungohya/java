package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

	public static void main(String[] args) {
		// insert, update, delete 작업 시 두 개의 객체만 사용
		Connection con = null;
		PreparedStatement pre = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into dept_temp (deptno,dname,loc)values (55,'NETWORK','SEOUL')";
			pre = con.prepareStatement(sql);

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
