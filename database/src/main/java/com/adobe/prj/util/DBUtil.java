package com.adobe.prj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private  static String URL = "jdbc:mysql://localhost:3306/NCG_JAVA";
    private  static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String USER = "root";
    private static String PWD = "Welcome123";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    public void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }
}
