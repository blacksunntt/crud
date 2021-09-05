/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author thanh
 */
public class ProductDao extends DBContext {

    public int countProduct() {
        try {
            String query = "SELECT COUNT(*) AS total FROM [Products]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int countSearchProduct(String searchStr) {
        try {
            String query = "SELECT COUNT(*) AS total FROM [Products] WHERE [name] LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + searchStr + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Product> getProducts(int pageIndex, int pageSize) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String query = "SELECT [id],[name],[image],[price] FROM\n"
                    + "(SELECT *, ROW_NUMBER() OVER (ORDER BY [id] ASC) AS row_num \n"
                    + "FROM [ManageProducts].[dbo].[Products]) TBL\n"
                    + "WHERE row_num >= (? - 1) * ? + 1 \n"
                    + "AND row_num <= (? * ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                list.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Product> searchProducts(int pageIndex, int pageSize, String searchStr) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String query = " SELECT [id],[name],[image],[price] FROM\n"
                    + "(SELECT *, ROW_NUMBER() OVER (ORDER BY [id] ASC) AS row_num \n"
                    + " FROM [ManageProducts].[dbo].[Products] \n"
                    + " WHERE [name] LIKE ?) TBL\n"
                    + "WHERE row_num >= (? - 1) * ? + 1 \n"
                    + "AND row_num <= (? * ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + searchStr + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                list.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getProductById(int id) {
        Product p = new Product();
        try {
            String query = "SELECT [id],[name],[image],[price] "
                    + "FROM [ManageProducts].[dbo].[Products] "
                    + "WHERE [id] = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void addProduct(String name, String imageFileName, float price) {
        try {
            String sql = "INSERT INTO [ManageProducts].[dbo].[Products] ([name],[image],[price])\n"
                    + "VALUES (?,?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, imageFileName);
            ps.setFloat(3, price);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProduct(Product p) {
        try {
            String sql = "UPDATE [ManageProducts].[dbo].[Products]\n"
                    + "SET [name] = ?, [image] = ?, [price] = ?\n"
                    + "WHERE [id] = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImage());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM [ManageProducts].[dbo].[Products]\n"
                    + "WHERE [id] = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
