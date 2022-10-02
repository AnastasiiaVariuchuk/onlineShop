package onlineShop.dao.idbcMySQL.people;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipeople.IUsersDAO;
import onlineShop.models.people.Employees;
import onlineShop.models.people.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UsersDAO implements IUsersDAO {
    private static final Logger logger = LogManager.getLogger(UsersDAO.class);
    public Users getUsersById(ResultSet resultSet) throws SQLException {
        Users users1 = new Users();
        users1.setIdUser(resultSet.getInt("iduser"));
        users1.setUserName(resultSet.getString("userName"));
        users1.setUserEmail(resultSet.getString("email"));
        users1.setUserPassword(resultSet.getString("password"));
        users1.setIdCustomer(resultSet.getInt("idcustomer"));
        return users1;
    }

    @Override
    public Users getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE iduser=" + id);
            if (resultSet.next()) {
                logger.info(getUsersById(resultSet));
                return getUsersById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(statement);
            ConnectionUtil.close(connection);
        }
        return null;
    }


    @Override
    public List<Users> getAll() {
        List<Users> users = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(getUsersById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return users;
    }

    @Override
    public void add(Users users) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, users.getIdUser());
            preparedStatement.setString(2, users.getUserName());
            preparedStatement.setString(3, users.getUserEmail());
            preparedStatement.setString(4, users.getUserPassword());
            preparedStatement.setInt(5, users.getIdCustomer());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void update(Users users) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET userName=?, " +
                    "email=?, password=?, idcustomer=? WHERE iduser=?");
            preparedStatement.setString(1, users.getUserName());
            preparedStatement.setString(2, users.getUserEmail());
            preparedStatement.setString(3, users.getUserPassword());
            preparedStatement.setDouble(4, users.getIdCustomer());
            preparedStatement.setInt(5, users.getIdUser());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + users.getUserName());
            } else
                logger.info("Update process was failed: " + users.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users " +
                    "WHERE iduser=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
