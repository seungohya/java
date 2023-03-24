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

	}// getRows 종료

	public boolean insertRow(DeptDTO dto) {
		con = getConnection();
		boolean isSuccess = false;
		String sql = "insert into dept_temp values (?, ?, ?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, dto.getDeptno());
			pre.setString(2, dto.getDname());
			pre.setString(3, dto.getLoc());
			int result = pre.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}
		return isSuccess;
	}

	public boolean updateRow(int deptno, String dname, String loc, int updateNo) {
		con = getConnection();
		boolean isSuccess = false;
		String sql = "";
		try {
			if (updateNo == 1) { // 부서명 수정
				sql = "update dept_temp set dname=? where deptno=?";
				pre = con.prepareStatement(sql);
				pre.setString(1, dname);
				pre.setInt(2, deptno);
			} else if (updateNo == 2) { // 위치 수정
				sql = "update dept_temp set loc=? where deptno=?";
				pre = con.prepareStatement(sql);
				pre.setString(1, loc);
				pre.setInt(2, deptno);
			}
			int result = pre.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}
		return isSuccess;
	}

	public boolean removeDepartment(int deptno) {
		con = getConnection(); // 데이터베이스 연결을 위한 커넥션 객체를 가져옵니다.
		boolean isSuccess = false; // 삭제 성공 여부를 저장할 변수입니다.
		String sql = ""; // SQL문을 저장할 변수입니다.
		try {
			sql = "delete from dept_temp where deptno=?"; // 부서번호가 일치하는 행을 삭제하는 SQL문입니다.
			pre = con.prepareStatement(sql); // SQL문을 실행하기 위한 PreparedStatement 객체를 생성합니다.
			pre.setInt(1, deptno); // SQL문의 ?에 값을 채워줍니다.
			int result = pre.executeUpdate(); // SQL문을 실행하고, 삭제된 행의 수를 리턴합니다.
			if (result > 0) { // 삭제된 행의 수가 0보다 크다면,
				isSuccess = true; // 삭제 성공 여부를 true로 변경합니다.
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력합니다.
		} finally {
			close(con, pre, rs); // 데이터베이스 연결을 종료합니다.
		}
		return isSuccess; // 삭제 성공 여부를 반환합니다.
	}

}
