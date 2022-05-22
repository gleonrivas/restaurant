package utilities;

import models.Orders;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ddbb.DDBBConecction.closeConnection;
import static ddbb.DDBBConecction.openConnection;

public class Kitchen_Utilities {

    public static List<Orders> getForKitchen(){

        List<Orders> orders = new ArrayList<>();

        Connection c = openConnection();

        Orders order = null;

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM product_orders order by id_orders desc");
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                order = new Orders(
                        0,0,
                        rs.getInt("id_product"),
                        rs.getInt("quantity"),
                        rs.getInt("state"));
                orders.add(order);
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return orders;
    }

    public static void modifyState(Orders order){
        //storing in a variable the ddbb connection
        Connection c = openConnection();
        try {
            //storage a query.
            PreparedStatement update = c.prepareStatement("update product_orders " +
                    "set state = ?" + " where id_orders = ?");

            update.setInt(1, 1),
            update.setInt(2, order.getId_order());


            update.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            closeConnection(c);
        }
    }


}
