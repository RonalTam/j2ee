package tam.dev.data.driver;

import tam.dev.data.util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDriver {
    private static MySQLDriver instance;
    private MySQLDriver() {

    }
    public static MySQLDriver getInstance() {
        if (instance == null) {
            instance = new MySQLDriver();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ket noi thanh cong!");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
