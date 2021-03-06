package utilities;

import models.Product;
import models.Table;
import models.TableAvailability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ddbb.DDBBConecction.closeConnection;
import static ddbb.DDBBConecction.openConnection;

public class Table_Utilities {
    public static void createTable(Table table) {
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into tables (id, availability, capacity)"
                    + "values(?,?,?)");

            insert.setInt(1, table.getId());
            insert.setString(2, table.gettAvailability().toString());
            insert.setInt(3, table.getCapacity());
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

    public static Table getById(int id){

        Connection c = openConnection();
        Table table = null;

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM tables where id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                table = new Table(
                        rs.getInt("id"),
                        TableAvailability.valueOf(rs.getString("availability")),
                        rs.getInt("capacity"));
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return table;
    }

    public static void updateTable(Table table){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement update = c.prepareStatement("UPDATE tables " + "set id = ?, capacity = ? " + "WHERE id = ? ");

            update.setInt(1, table.getId());
            update.setInt(2, table.getCapacity());
            update.setInt(3, table.getId());


            update.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecuci??n:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            closeConnection(c);
        }
    }

    public static void deleteTable (int id){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement delete = c.prepareStatement("delete from tables where id = ? ");

            delete.setInt(1, id);
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

    public static List<Table> getAllt(){

        List<Table> tables = new ArrayList<>();

        Connection c = openConnection();

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM tables");
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                Table table = null;
                table = new Table(
                        rs.getInt("id"),
                        TableAvailability.valueOf(rs.getString("availability")),
                        rs.getInt("capacity"));
                tables.add(table);
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return tables;
    }
}
