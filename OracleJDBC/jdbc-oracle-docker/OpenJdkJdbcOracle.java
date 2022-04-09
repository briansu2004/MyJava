import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

class OpenJdkJdbcOracle {
    public static void main(String args[]) {
        try {
            OracleDataSource ods = new OracleDataSource();

            // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
            ods.setURL("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
            ods.setUser("[Username]");
            ods.setPassword("[Password]");

            Connection conn = ods.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT 'Hello World!' FROM dual");
            ResultSet rslt = stmt.executeQuery();
            while (rslt.next()) {
                System.out.println(rslt.getString(1));
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
