package ddbb;

import models.Employee;
import models.EmployeeType;

import java.sql.*;

public class DDBBConecction {

    private static final String url = "jdbc:mariadb://localhost:3306/restaurant";
    private static final String user = "root";
    private static final String password = "Ludaiz13";


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

    public static Employee getById(Integer id){

        Connection c = openConnection();
        Employee employee = null;

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM employee where id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("address"),
                        rs.getInt("phone"),
                        rs.getString("dni"),
                        EmployeeType.values()[rs.getInt("employee_type")]);
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return employee;
    }


}
