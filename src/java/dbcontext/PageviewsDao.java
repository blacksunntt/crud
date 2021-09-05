/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class PageviewsDao extends DBContext {

    public int getPageviews() {
        int pageviews = 0;
        try {
            String query = "SELECT [pageviews]\n"
                    + "FROM [ManageProducts].[dbo].[Pageviews]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pageviews = rs.getInt("pageviews");
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PageviewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pageviews;
    }

    public void updatePageviews() {
        try {
            String query = "UPDATE [ManageProducts].[dbo].[Pageviews]\n"
                    + "SET [pageviews] += 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
//            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PageviewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
