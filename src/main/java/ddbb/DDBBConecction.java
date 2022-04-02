package ddbb;

import java.sql.*;

public class DDBBConecction {

    private static final String url = "jdbc:mariadb://localhost:3306/restaurant";
    private static final String user = "root";
    private static final String password = "1234";


    private static Connection connectToDdbb() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection Error:" + e.toString());
            return null;
        }
        return connection;
    }
}