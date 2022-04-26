package ddbb;

import models.Person;
import models.PersonType;

import java.sql.*;

public class DDBBConecction {

    private static final String url = "jdbc:mariadb://jarvis.cahhr3txbelz.eu-west-3.rds.amazonaws.com:3306/restaurant";
    private static final String user = "admin";
    private static final String password = "bekda0-ganzes-nuTkit";


    public static Connection openConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection Error:" + e.toString());
            return null;
        }
        return connection;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c !=null) {
                c.close();
            }
        } catch (Exception e) {
            System.out.println("Error while closing connection: "
                    + e.toString());
        }
    }

}
