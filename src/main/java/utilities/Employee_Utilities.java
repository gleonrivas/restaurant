package utilities;

import models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ddbb.DDBBConecction.*;

public class Employee_Utilities {

    public static void createEmployee(Employee employee){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into empployee (id, name, surname, address, phone, dni, eType)" + "values(?,?,?,?,?,?,?)");

            insert.setInt(1, employee.getId());
            insert.setString(2, employee.getName());
            insert.setString(3, employee.getSurname());
            insert.setString(4, employee.getAddress());
            insert.setInt(5, employee.getPhone());
            insert.setString(6, employee.getDni());
            insert.setInt(7, employee.geteType().ordinal());

            //insert execution command.
            insert.executeUpdate();

        //detects the error and displays its message.
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        //finally closes connection calling closing method.
        } finally {
            closeConnection(c);
        }
    }

    public static void deleteEmployee (Employee employee){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement delete = c.prepareStatement("delete from employee where id = ? ");

            delete.setInt(1, employee.getId());
            //delete execution command
            delete.executeUpdate();

        //detects the error and displays its message.
        } catch (SQLException sqle) {
            System.out.println("Error in deleting:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        //finally closes connection calling closing method.
        } finally {
             closeConnection(c);
        }
    }

    public static void updateEmployee(Employee employee){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement update = c.prepareStatement("update employee " +
                    "set id = ? , name = ? , surname = ? , address = ?, phone = ?, dni = ?, employee_type = ?" +
                    "where id = ? ");

            update.setInt(1, employee.getId());
            update.setString(2, employee.getName());
            update.setString(3, employee.getSurname());
            update.setString(4, employee.getAddress());
            update.setInt(5, employee.getPhone());
            update.setString(6, employee.getDni());
            update.setInt(7, employee.geteType().ordinal());


            //update execution coomand.
            update.executeUpdate();

        //detects the error and displays its message.
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        //finally closes connection calling closing method.
        } finally {
            closeConnection(c);
        }
    }

    // This create and update an employee by calling it's methods.
    public static void CreateOrUpdateEmployee(Employee employee){

        Employee ddbbEmployee = getById(employee.getId());

        if(ddbbEmployee != null){
            updateEmployee(employee);
        }else{
            createEmployee(employee);
        }
    }

}
