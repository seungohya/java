package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

//1) connection 가져오기 
//-드라이버 로드
//-연결문자열 연결 시도
//2) DB 서버에 접속해서 원하는 작업(CRUD)하기
//- C : create, R: read, U: update, D: delete
public class Select {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null; // sql 전달
		ResultSet rs = null; // sql(select 결과 저장)
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
//			if (con != null) {
//				System.out.println("연결되었습니다.");
//			}
//			emp 테이블의 내용 가져오기 
//			String sql = "SELECT * FROM emp";
			String sql = "SELECT * FROM emp where deptno = 20";
			
			//서버로  sql 구문 전송
			pstmt = con.prepareStatement(sql);
			// 전송된 sql 구문 실행 후 결과를 ResultSet 객체 (테이블형태)에 담게 됨
			rs = pstmt.executeQuery();

			// ResultSet 객체 안에 한 행씩 읽어오면서 화면 출력
			//rs.next() : ResultSet 객체 안에 행이 존재한다면 true 돌려줌 , 없으면 false
			while (rs.next()) {
			    System.out.println(String.format("%-4d %-8s %-8s %4d %-10s %5d %4d %4d",
			        rs.getInt(1), rs.getString("ename"), rs.getString(3),
			        rs.getInt("mgr"), rs.getString(5), rs.getInt(6),
			        rs.getInt(7), rs.getInt("deptno")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}