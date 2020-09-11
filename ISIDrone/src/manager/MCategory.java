package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;
import entities.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import util.Hash;

public class MCategory {

    public static ArrayList<Category> getCategories() throws IOException {

        ArrayList<Category> categories = new ArrayList<Category>();

        try {
            MDB.connect();
            String query = "SELECT * FROM category";
            ResultSet rs = MDB.execQuery(query);
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return categories;
    }

    public static int addCategorie(Category category) throws IOException {
        int code = isExistName(category.getName());

        if (code == 1) {
            try {
                MDB.connect();

                String query = "INSERT INTO category (`name`, `description`, `order`, `isActive`) VALUES ( ?, ?, ?, ?)";

                PreparedStatement ps = MDB.getPS(query);

                ps.setString(1, category.getName());
                ps.setString(2, category.getDescription());
                ps.setInt(3, category.getOrder());
                ps.setBoolean(4, category.isIsActive());
                //ps.setInt(5, user.getShipAddress().getId());

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MDB.disconnect();
            }
        }
        return code;
    }

    public static int isExist(int category) throws IOException {
        int isExist = -1;
        try {
            MDB.connect();
            String query = "SELECT 'exist' FROM category WHERE id = ?";
            PreparedStatement ps = MDB.getPS(query);

            ps.setInt(1, category);
            ResultSet rs = ps.executeQuery();

            isExist = (rs.first() ? 0 : 1);
        } catch (SQLException e) {
            isExist = -1;
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return isExist;
    }

    public static int isExistName(String category) throws IOException {
        int isExist = -1;
        try {
            MDB.connect();
			String query = "SELECT 'exist' FROM category WHERE name like ?";
            PreparedStatement ps = MDB.getPS(query);

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            isExist = (rs.first() ? 0 : 1);
        } catch (SQLException e) {
            isExist = -1;
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return isExist;
    }
}
