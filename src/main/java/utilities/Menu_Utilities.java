package utilities;

import models.Product;
import models.ProductType;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ddbb.DDBBConecction.closeConnection;
import static ddbb.DDBBConecction.openConnection;

public class Menu_Utilities {

    public static List<Product> getProduct(){

        Connection c = openConnection();
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement query = c.prepareStatement("SELECT name, price FROM product order by typo");
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        ProductType.valueOf(rs.getString("typo")),
                        rs.getString("name"),
                        rs.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return products;
    }

}
