package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBHandler {
    private static final String CON_STR_MAIN_DB = "jdbc:sqlite:C:/Users/User/Desktop/ourTheatre/src/main/java/DataBase/MainDB.s3db";
    private static Connection instance = null;

    static synchronized Connection getConnection() throws SQLException {
        if (instance == null)
            instance = DriverManager.getConnection(CON_STR_MAIN_DB);
        return instance;
    }
}