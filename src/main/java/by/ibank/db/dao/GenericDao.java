package by.ibank.db.dao;

import by.ibank.db.connection.DbConnection;
import by.ibank.db.entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public abstract class GenericDao<T extends Entity> {

    private static final String GENERIC_GET_BY_ID_QUERY = "SELECT * FROM %s WHERE id=%d";

    public T getById(long id) {
        String sql = "select " + getIdColumnName() + ", " + String.join(",", getColumnNames()) + " from " + getTableName()
                + " where " + getIdColumnName() + "= ?";

        ResultSet resultSet = null;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            List<T> entities = mapRows(resultSet);
            if(entities.size() == 1){
                return entities.get(0);
            } else {
                throw new RuntimeException("Expected 1 entity but found " + entities.size());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Long create(T entity){
        String sql = "insert into " + getTableName() + "(" + String.join(",", getColumnNames()) + ") values ("
                + getParamsTemplate(getColumnNames().size()) + ")" ;

        ResultSet resultSet = null;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection != null ? connection.prepareStatement(sql) : null) {
            setParameters(preparedStatement, entity);
            preparedStatement.executeUpdate();

            resultSet = connection.createStatement().executeQuery("select max(" + getIdColumnName() + ") from " + getTableName());
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<T> getAll() {
        String sql = "select " + getIdColumnName() + ", " + String.join(",", getColumnNames()) + " from " + getTableName();

        ResultSet resultSet = null;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            List<T> entities = mapRows(resultSet);
            return entities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public T update(T entity){return null;} //TODO

    public T delete(T entity){return null;} //TODO

    protected abstract String getTableName();

    protected String getIdColumnName() {
        return "id";
    }

    protected abstract T mapRow(ResultSet resultSet) throws SQLException;

    protected abstract void setParameters(PreparedStatement preparedStatement, T entity) throws SQLException;

    protected abstract List<String> getColumnNames();

    private List<T> mapRows(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(mapRow(resultSet));
        }
        return result;
    }

    private String getParamsTemplate(int paramCount) {
        String[] params = new String[paramCount];
        for (int i = 0; i < paramCount; i++) {
            params[i] = "?";
        }
        return String.join(",",params);
    }

}
