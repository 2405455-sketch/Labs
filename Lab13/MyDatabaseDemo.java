import java.sql.*;

class MyDatabaseDemo {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:49161:XE";
        String user = "java";
        String password = "java";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            String tableName = "student";
            rs = stmt.executeQuery("SELECT * FROM " + tableName);

            System.out.printf("%-5s %-12s %-5s %-10s%n", "ID", "NAME", "AGE", "COURSE");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.printf(
                        "%-5d %-12s %-5d %-10s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}