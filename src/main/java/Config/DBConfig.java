/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C.m™ Lap MasterS
 */
public class DBConfig {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    private static void createConnection() throws SQLException {
        String db_url = "jdbc:sqlite:D:\\DEV\\repository_manager\\database.db";
        DBConfig.connection = DriverManager.getConnection(db_url);
    }

    private static boolean closeConnection() {
        try {
            DBConfig.connection.close();
            return DBConfig.connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(DBConfig.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
