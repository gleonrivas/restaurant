package utilities;

import models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ddbb.DDBBConecction.*;

public class Employee_Utilities {

    public static void createEmployee(Person person){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into employee (id, name, surname, address, phone, dni, employee_type)"
                    + "values(?,?,?,?,?,?,?)");

            insert.setInt(1, person.getId());
            insert.setString(2, person.getPname());
            insert.setString(3, person.getSurname());
            insert.setString(4, person.getAddress());
            insert.setInt(5, person.getPhone());
            insert.setString(6, person.getDni());
            insert.setString(7, person.geteType().toString());

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

    public static void deleteEmployee (Person person){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement delete = c.prepareStatement("delete from employee where id = ? ");

            delete.setInt(1, person.getId());
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

    public static void updateEmployee(Person person){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement update = c.prepareStatement("update employee " +
                    "set id = ? , name = ? , surname = ? , address = ?, phone = ?, dni = ?, employee_type = ?" +
                    "where id = ? ");

            update.setInt(1, person.getId());
            update.setString(2, person.getPname());
            update.setString(3, person.getSurname());
            update.setString(4, person.getAddress());
            update.setInt(5, person.getPhone());
            update.setString(6, person.getDni());
            update.setString(7, person.geteType().toString());


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

    // This create and update an person by calling it's methods.
    public static void CreateOrUpdateEmployee(Person person){

        Person ddbbPerson = getById(person.getId());

        if(ddbbPerson != null){
            updateEmployee(person);
        }else{
            createEmployee(person);
        }
    }

}
