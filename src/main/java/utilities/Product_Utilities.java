package utilities;

import models.Product;
import models.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ddbb.DDBBConecction.*;

public class Product_Utilities {

    public static Product getById(int id){

        Connection c = openConnection();
        Product product = null;

        try {
            PreparedStatement query = c.prepareStatement("SELECT * FROM product where id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        ProductType.valueOf(rs.getString("typo")),
                        rs.getString("name"),
                        rs.getInt("code"),
                        rs.getDouble("price"));
            }

        } catch (SQLException sqle) {
            System.out.println("Execution not succeed:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            closeConnection(c);
        }

        return product;
    }

    public static void createProduct(Product product){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement insert = c.prepareStatement("insert into product (id, typo, name, code, price)"
                    + "values(?,?,?,?,?)");

            insert.setInt(1, product.getId());
            insert.setString(2, product.getProductType().toString());
            insert.setString(3, product.getName());
            insert.setInt(4, product.getCode());
            insert.setDouble(5, product.getPrice());
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

    public static void updateProduct(Product product){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement update = c.prepareStatement("update product " +
                    "set id = ? , typo = ? , name = ? , code = ?, price = ?" +
                    "where id = ? ");

            update.setInt(1, product.getId());
            update.setString(2, product.getProductType().toString());
            update.setString(3, product.getName());
            update.setInt(4, product.getCode());
            update.setDouble(5, product.getPrice());
            update.setInt(6, product.getId());

            update.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            closeConnection(c);
        }
    }

    public static void deleteProduct (int i){
        //storing in a variable the ddbb connection
        Connection c = openConnection();

        try {
            //storage a query.
            PreparedStatement delete = c.prepareStatement("delete from product where id = ? ");

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


}
