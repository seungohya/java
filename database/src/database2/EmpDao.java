package database2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class EmpDao {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "TIGER";

		con = DriverManager.getConnection(url, user, password);
		return con;

	}

	public void close(Connection con, PreparedStatement pre, ResultSet rs) {
		try {

			rs.close();

			pre.close();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, PreparedStatement pre) {
		try {

			pre.close();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EmpDTO> getEmpByName(String ename) {
		ArrayList<EmpDTO> list = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select empno, ename, job, hiredate from emp_temp where ename=?";
			pre = con.prepareStatement(sql);
			pre.setString(1, ename);
			rs = pre.executeQuery();
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}
		return list;
	}

	public EmpDTO getEmpByEmpno(int empno) throws Exception {
		con = getConnection();

		String sql = "SELECT empno,ename,job,sal,comm,deptno FROM emp_temp WHERE empno=?";
		EmpDTO dto = null;

		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, empno);
			rs = pre.executeQuery();

			if (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre, rs);
		}

		return dto;
	}

	public void insertEmp(EmpDTO emp) throws Exception {
		con = getConnection();

		String sql = "INSERT INTO emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, emp.getEmpno());
			pre.setString(2, emp.getEname());
			pre.setString(3, emp.getJob());
			pre.setObject(4, emp.getMgr());
			pre.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
			pre.setInt(6, emp.getSal());
			pre.setObject(7, emp.getComm());
			pre.setInt(8, emp.getDeptno());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre);
		}
	}

	public void deleteEmpByEmpno(int empno) throws Exception {
		con = getConnection();

		String sql = "DELETE FROM emp_temp WHERE empno=?";

		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, empno);
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre);
		}
	}

	public void updateEmp(EmpDTO emp) throws Exception {
		con = getConnection();

		String sql = "UPDATE emp_temp SET sal=? WHERE empno=?";

		try {
			pre = con.prepareStatement(sql);

			pre.setInt(1, emp.getSal());

			pre.setInt(2, emp.getEmpno());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pre);
		}
	}
//	public EmpDTO getEmpByEmpno1(int empno) throws Exception {
//	    con = getConnection();
//
//	    String sql = "SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp_temp WHERE empno=?";
//	    EmpDTO dto = null;
//
//	    try {
//	        pre = con.prepareStatement(sql);
//	        pre.setInt(1, empno);
//	        rs = pre.executeQuery();
//
//	        if (rs.next()) {
//	            dto = new EmpDTO();
//	            dto.setEmpno(empno);
//	            dto.setEname(rs.getString("ename"));
//	            dto.setJob(rs.getString("job"));
//	            dto.setMgr(rs.getInt("mgr"));
//	            dto.setHiredate(rs.getDate("hiredate"));
//	            dto.setSal(rs.getInt("sal"));
//	            dto.setComm(rs.getInt("comm"));
//	            dto.setDeptno(rs.getInt("deptno"));
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        close(con, pre, rs);
//	    }
//
//	    return dto;
//	}

}
