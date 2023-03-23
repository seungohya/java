package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select1 {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "TIGER";
            con = DriverManager.getConnection(url, user, password);

            String sql = "select * from dept_temp where deptno=70";

            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString("dname") + "\t" + rs.getString("loc"));
            } else {
                System.out.println("조회된 결과가 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
