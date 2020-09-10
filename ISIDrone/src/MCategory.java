import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;

import java.util.logging.Level;
import java.util.logging.Logger;
import manager.MDB;

import java.io.IOException;


public class MCategory {
	public static ArrayList<Category> getCategories() throws IOException{
		ArrayList<Category> categories = new ArrayList<Category>();
                

		try {
			MDB.connect();
			String query = "SELECT * FROM category";
			ResultSet rs = MDB.execQuery(query);
			while(rs.next()) {
				categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getBoolean(5)));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();	
		}
		
		return categories;
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
		}
		finally {
			MDB.disconnect();	
		}
		
		return isExist;
	}
        public static void modifyCategory(int category) throws IOException{
            try {
                MDB.connect();
                String modifyQuery = "UPDATE $1 SET $2,$3,$4,$5 WHERE id=$6";
            } catch (SQLException ex) {
                Logger.getLogger(MCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                MDB.disconnect();
            }
        }
}
