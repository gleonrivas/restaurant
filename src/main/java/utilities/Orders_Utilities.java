package utilities;

import models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ddbb.DDBBConecction.closeConnection;
import static ddbb.DDBBConecction.openConnection;

public class Orders_Utilities {

    public static void insertIntoOrders(Orders order){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into orders (id_employee, id_tables) "+" values(?,?)");

            insert.setInt(1, order.getIdEmployee());
            insert.setInt(2, order.getIdTable());

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


    public static int findLastId(){
        //storing in a variable the ddbb connection
        Connection c = openConnection();
        int id = 0;

        try {
            //storage a query.
            PreparedStatement wonder = c.prepareStatement("SELECT id FROM orders order by id DESC LIMIT 1");
            ResultSet rs = wonder.executeQuery();

            while (rs.next()){
                id = (rs.getInt("id"));
            }

            //detects the error and displays its message.
        } catch (SQLException sqle) {
            System.out.println("Error while executing:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
            //finally closes connection calling closing method.
        } finally {
            closeConnection(c);
        }
        return id;

    }


    public static void insertIntoProductOrders(Orders order){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into product_orders (quantity, state, id_orders, id_product) " + " values(?,?,?,?)");

            insert.setInt(1, order.getQuantity());
            insert.setInt(2, order.setState(0));
            insert.setInt(3, findLastId());
            insert.setInt(4, order.getIdProduct());

            //insert execution command.
            insert.executeQuery();

            //detects the error and displays its message.
        } catch (SQLException sqle) {
            System.out.println("Error while executing:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
            //finally closes connection calling closing method.
        } finally {
            closeConnection(c);
        }
    }
}
