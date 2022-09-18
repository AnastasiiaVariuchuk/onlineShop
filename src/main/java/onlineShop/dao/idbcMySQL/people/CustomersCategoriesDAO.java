package onlineShop.dao.idbcMySQL.people;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersCategoriesDAO;
import onlineShop.models.people.CustomersCategories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersCategoriesDAO implements ICustomersCategoriesDAO {
    private static final Logger logger = LogManager.getLogger(CustomersCategoriesDAO.class);

    private CustomersCategories getCustomersCategoriesById(ResultSet resultSet) throws SQLException {
        CustomersCategories customersCategories1 = new CustomersCategories();
        customersCategories1.setIdCustomersCategory(resultSet.getInt("idcustomersCategory"));
        customersCategories1.setCustomersCategoryType(resultSet.getString("customersCategoryType"));
        customersCategories1.setCustomersCategoryDiscount(resultSet.getBoolean("CustomersCategoryDiscount"));
        return customersCategories1;
    }
    @Override
    public CustomersCategories getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customersCategories WHERE idcustomersCategories=" + id);
            if (resultSet.next()) {
                logger.info(getCustomersCategoriesById(resultSet));
                return getCustomersCategoriesById(resultSet);
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
    public List<CustomersCategories> getAll() {
        List<CustomersCategories> customersCategories = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customersCategories");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customersCategories.add(getCustomersCategoriesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return customersCategories;
    }

    @Override
    public void add(CustomersCategories customersCategories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO customersCategories VALUE(default, ?, ?)");
            preparedStatement.setString(1, customersCategories.getCustomersCategoryType());
            preparedStatement.setBoolean(2, customersCategories.isCustomersCategoryDiscount());
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
    public void update(CustomersCategories customersCategories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE customersCategories SET customersCategoryType=?, " +
                    "customersCategoryDiscount=? WHERE idcustomersCategory=?");
            preparedStatement.setString(1, customersCategories.getCustomersCategoryType());
            preparedStatement.setBoolean(2, customersCategories.isCustomersCategoryDiscount());
            preparedStatement.setInt(3, customersCategories.getIdCustomersCategory());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + customersCategories.getIdCustomersCategory() + "-" +
                        customersCategories.getCustomersCategoryType());
            } else
                logger.info("Update process was failed: " + customersCategories.getIdCustomersCategory() + "-" +
                        customersCategories.getCustomersCategoryType());
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
            preparedStatement = connection.prepareStatement("DELETE FROM customersCategories " +
                    "WHERE idcustomersCategories=" + id);
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
