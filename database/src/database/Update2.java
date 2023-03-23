package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update2 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pre = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");
            // 데이터베이스 연결
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "TIGER";
            con = DriverManager.getConnection(url, user, password);

            // 사용자로부터 업데이트할 부서 정보 입력받기
            System.out.print("업데이트할 부서 코드를 입력하세요: ");
            int deptno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("업데이트할 부서명을 입력하세요: ");
            String dname = scanner.next();

            // SQL문 작성 및 실행
            String sql = "update dept_temp set dname = ? where deptno = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, dname);
            pre.setInt(2, deptno);

            int result = pre.executeUpdate();
            if (result > 0) {
                System.out.println("업데이트 성공");
            } else {
                System.out.println("업데이트할 부서정보가 존재하지 않습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 객체 해제
            try {
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
