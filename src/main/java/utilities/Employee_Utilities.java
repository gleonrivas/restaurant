package utilities;

import models.Person;
import models.PersonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            System.out.println("Error while executing:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        //finally closes connection calling closing method.
        } finally {
            closeConnection(c);
        }
    }

    public static void deleteEmployee (int i){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement delete = c.prepareStatement("delete from employee where id = ? ");

            delete.setInt(1, i);
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
            update.setInt(8, person.getId());


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


    public static Person getById(int id){

        Connection c = openConnection();
        Person person = null;

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM employee where id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                person = new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("address"),
                        rs.getInt("phone"),
                        rs.getString("dni"),
                        PersonType.valueOf(rs.getString("employee_type")));
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return person;
    }

}
