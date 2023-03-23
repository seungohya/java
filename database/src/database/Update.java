package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // mydb는 연결할 데이터베이스명
        String username = "scott"; // 데이터베이스 접속 계정명
        String password = "TIGER"; // 데이터베이스 접속 계정 비밀번호
        String sql = "UPDATE dept_temp SET dname = 'WEB' WHERE deptno = 55"; // 부서번호가 55번인 부서의 이름을 "WEB"으로 변경하는 SQL 문

        try {
            Class.forName("oracle.jdbc.OracleDriver"); // JDBC 드라이버 로드
            conn = DriverManager.getConnection(url, username, password); // 데이터베이스 연결

            pstmt = conn.prepareStatement(sql); // SQL 문 실행을 위한 PreparedStatement 객체 생성
            int result = pstmt.executeUpdate(); // SQL 문 실행

            if (result > 0) {
                System.out.println("부서명이 변경되었습니다.");
            } else {
                System.out.println("변경된 부서가 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // ResultSet 객체 종료
                }
                if (pstmt != null) {
                    pstmt.close(); // PreparedStatement 객체 종료
                }
                if (conn != null) {
                    conn.close(); // 데이터베이스 연결 종료
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
    }
}
