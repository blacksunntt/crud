/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + database;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final String serverName = "DESKTOP-KLV5Q4J";
    private final String database = "ManageProducts";
    private final String portNumber = "1433";
    private final String username = "sa";
    private final String password = "12345678";

}
