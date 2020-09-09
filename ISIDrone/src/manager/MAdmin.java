/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Item;

/**
 *
 * @author rcorroch
 */
public class MAdmin {

    public static ArrayList<Item> getallitems() {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            MDB.connect();
            String query;
            PreparedStatement preparedStatement;
            ResultSet resultset;

            query = "SELECT * FROM product";
            preparedStatement = MDB.getPS(query);

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                items.add(getItemFromResultSet(resultset));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return items;
    }

    private static Item getItemFromResultSet(ResultSet resultset) {

        Item item = new Item();

        try {
            item.setId(resultset.getInt("id"));
            item.setCategory(resultset.getInt("category"));
            item.setName(resultset.getString("name"));
            item.setDescription(resultset.getString("description"));
            item.setPrice(resultset.getDouble("price"));
            item.setSerial(resultset.getString("serialNumber"));
            item.setImage(resultset.getString("imgName"));
            item.setStock(resultset.getInt("stockQty"));
            item.setActive(resultset.getBoolean("isActive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static boolean Deleteactor(int id) {
        int deleteItemTrue = 0;
        try {
            MDB.connect();
            String query;
            PreparedStatement preparedStatement;
           

            query = "delete FROM isidrone.product where id = ? ";
            preparedStatement = MDB.getPS(query);
            preparedStatement.setInt(1, id);
            deleteItemTrue = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return deleteItemTrue > 0;
    }

}
