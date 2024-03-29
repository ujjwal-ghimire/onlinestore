package nccs.onlinestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection connection;

    final static String subProtocal = "mysql";
    final static String host = "//localhost";
    final static String port = "3306";
    final static String database = "onlinestore";
    final static String userName = "root";
    final static String password = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:" + subProtocal + ":"
                    + host + ":" + port + "/" + database, userName, password);
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }

    }

}
