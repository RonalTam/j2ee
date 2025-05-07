package tam.dev.data.impl;

import tam.dev.dao.CategoryDAO;
import tam.dev.data.driver.MySQLDriver;
import tam.dev.data.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryImpl implements CategoryDAO {

    @Override
    public boolean insert(Category category) {
        String sql = "INSERT INTO CATEGORIES(NAME, description) VALUES(?, ?)";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.name);
            stmt.setString(2, category.description);

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Category category) {
        String sql = "UPDATE CATEGORIES SET NAME = ?, description = ? WHERE id = ?";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.name);
            stmt.setString(2, category.description);
            stmt.setInt(3, 1);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM  CATEGORIES WHERE id = ?";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 6);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Category find(int id) {
        String sql = "SELECT * FROM  CATEGORIES WHERE id = ?";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                return new Category(name, description);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM  CATEGORIES";
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                categories.add(new Category(name, description));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
