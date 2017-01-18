package by.ibank.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Formatter;


public final class DbConnection {

    private static final String URL_PREFIX = "jdbc:mysql://localhost:3306/%s?autoReconnect=true&useSSL=false";
    private static final String DEFAULT_DB_NAME = "bank";
    private static String DB_NAME = DEFAULT_DB_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DbConnection() {
    }

    public static Connection getConnection() {
        try {
            Formatter formatter = new Formatter();
            return DriverManager.getConnection(formatter.format(URL_PREFIX, DB_NAME).toString(), USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setDbName(String dbName) {
        DB_NAME = dbName;
    }
}
