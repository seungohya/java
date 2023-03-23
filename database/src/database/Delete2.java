package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete2 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pre = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "TIGER";
            con = DriverManager.getConnection(url, user, password);

            System.out.print("삭제할 부서번호를 입력하세요: ");
            int deptno = scanner.nextInt();

            String sql = "delete from dept_temp where deptno = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, deptno);

            int result = pre.executeUpdate();
            if (result > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제할 부서번호가 존재하지 않습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
