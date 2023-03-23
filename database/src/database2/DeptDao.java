package database2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDao {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "TIGER";

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	};

	// close():

	public void close(Connection con, PreparedStatement pre, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pre != null)
				pre.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, PreparedStatement pre) {
		try {
			if (pre != null)
				pre.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DeptDTO getRow(int deptno) {
		con = getConnection();

		String sql = "select *from dept_temp where deptno=?";
		DeptDTO dto = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, deptno);
			rs = pre.executeQuery();
			if (rs.next()) {
//				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
//				rs 를 DTO 에 담기
				deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);

				dto = new DeptDTO(deptno, dname, loc);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}
		return dto;

	}

	public ArrayList<DeptDTO> getRows() {
		ArrayList<DeptDTO> list = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select * from dept_temp";
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}
		return list;

	}

}