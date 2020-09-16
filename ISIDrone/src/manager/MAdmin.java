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
import entities.User;
import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author rcorroch
 */
public class MAdmin {

    public static ArrayList<Item> getallitems() throws IOException {
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

    public static boolean Deletitem(int id) throws IOException {
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

    public static boolean addItem(Item item) throws IOException {
        int itemAdd = 0;
        try {
            MDB.connect();
            String query;
            PreparedStatement ps;
            query = "INSERT INTO `isidrone`.`product` (`category`, `name`, `description`, `price`, `serialNumber`, `imgName`, `stockQty`, `isActive`) VALUES (? , ? , ? , ? , ? , ? , ? , ? );";
            ps = MDB.getPS(query);

            ps.setInt(1, item.getCategory());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getPrice());
            ps.setString(5, item.getSerial());
            ps.setString(6, item.getImage());
            ps.setInt(7, item.getStock());
            ps.setInt(8, item.getActiver());

            itemAdd = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return itemAdd > 0;
    }

    public static boolean DeleteOrder(int id) throws IOException {
        int deleteOrderTrue = 0;
        try {
            MDB.connect();
            String query;
            PreparedStatement preparedStatement;

            query = "delete FROM isidrone.order where id = ? ";
            preparedStatement = MDB.getPS(query);
            preparedStatement.setInt(1, id);
            deleteOrderTrue = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return deleteOrderTrue > 0;
    }

    public static ArrayList<User> getallusers() throws IOException {
        ArrayList<User> users = new ArrayList<User>();
        try {
            MDB.connect();
            String query;
            PreparedStatement preparedStatement;
            ResultSet resultset;

            query = "SELECT * FROM isidrone.user where userRole not like '1'";
            preparedStatement = MDB.getPS(query);

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                users.add(getUserFromResultSet(resultset));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return users;
    }

    private static User getUserFromResultSet(ResultSet resultset) {

        User user = new User();

        try {
            user.setId(resultset.getInt("id"));
            user.setLastName(resultset.getString("lastName"));
            user.setFirstName(resultset.getString("firstName"));
            user.setEmail(resultset.getString("email"));
            user.setUserRole(resultset.getInt("userRole"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<User> getSearchUser(String search) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        try {
            MDB.connect();
            String query;
            PreparedStatement ps;
            ResultSet rs;

            //query = "select * from product where upper(name) like upper(?) or upper(description) like upper(?) ;";
            query = "select * from User where upper(firstName) like upper( ? ) or upper(lastName) like upper( ? ) or upper(email) like upper( ? ) and userRole not like '1' ;";
            ps = MDB.getPS(query);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(getUserFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return users;

    }

}
