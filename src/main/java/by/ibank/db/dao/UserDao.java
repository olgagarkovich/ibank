package by.ibank.db.dao;

import by.ibank.db.entity.User;

import java.sql.ResultSet;


public class UserDao extends GenericDao<User> {

    private static final String TABLE_NAME = "users";

    @Override
    public User getById(long id) {
        User result = null;
        ResultSet resultSet = getResultsById(TABLE_NAME, id);
//        try {
//            if (resultSet != null && resultSet.next()) {
//                result = new User(resultSet.getLong("id"), resultSet.getString("name"),
//                        resultSet.getObject("released") != null ? resultSet.getObject("released", LocalDate.class) : null);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return result;
    }
}
