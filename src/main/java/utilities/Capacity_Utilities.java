package utilities;

import models.Table;
import models.TableAvailability;
import org.mariadb.jdbc.export.Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ddbb.DDBBConecction.openConnection;

public class Capacity_Utilities {

    /*public static void getAvailability(int id){
        Connection c = openConnection();
        Table table = null;

        try {
            PreparedStatement query = c.prepareStatement("select * from tables where id = ?");
            query.setInt(1,id);
            ResultSet rs = query.executeQuery();

            while (rs.next()){
                table = new Table(
                        rs.getInt("id"),
                        rs.getString("availability"));
            }

        } catch (SQLException e) {
        }
    }*/

}
