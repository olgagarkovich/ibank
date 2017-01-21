package by.ibank.db.dao;

import by.ibank.db.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class UserDao extends GenericDao<User> {

    private static final String TABLE_NAME = "users";

    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("login"),
                resultSet.getString("pass"));
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, User entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getLogin());
        preparedStatement.setString(3, entity.getPass());
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected List<String> getColumnNames() {
        return Arrays.asList("name","login","pass");
    }
}
