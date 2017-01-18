package by.ibank.db.dao;

import by.ibank.db.connection.DbConnection;
import by.ibank.db.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

public abstract class GenericDao<T extends Entity> {

    private static final String GENERIC_GET_BY_ID_QUERY = "SELECT * FROM %s WHERE id=%d";

    public abstract T getById(long id);

    protected ResultSet getResultsById(String tableName, long id) {
        Connection connection = DbConnection.getConnection();
        try {
            Formatter formatter = new Formatter();
            Statement statement = connection.createStatement();
            return statement.executeQuery(formatter.format(GENERIC_GET_BY_ID_QUERY, tableName, id).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
