package utilities;

import models.Person;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ddbb.DDBBConecction.*;

public class Product_Utilities {

    public static void createProduct(Product product){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into employee (id, type, description, code, price)"
                    + "values(?,?,?,?,?)");

            insert.setInt(1, product.getId());
            insert.setString(2, product.getProductType().toString());
            insert.setString(3, product.getDescription());
            insert.setInt(4, product.getCode());
            insert.setDouble(5, product.getPrice());
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


}
