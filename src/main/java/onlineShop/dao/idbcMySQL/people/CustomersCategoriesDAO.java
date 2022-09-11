package onlineShop.dao.idbcMySQL.people;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQL.places.AddressesDAO;
import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersCategoriesDAO;
import onlineShop.models.people.CustomersCategories;
import onlineShop.models.places.Addresses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersCategoriesDAO implements ICustomersCategoriesDAO {
    private static final Logger logger = LogManager.getLogger(CustomersCategoriesDAO.class);
    List<CustomersCategories> customersCategories = new LinkedList<>();

    private CustomersCategories getCustomersCategoriesById(ResultSet resultSet) throws SQLException {
        CustomersCategories customersCategories1 = new CustomersCategories();
        customersCategories1.setIdCustomersCategory(resultSet.getInt("idcustomersCategory"));
        customersCategories1.setCustomersCategoryType(resultSet.getString("customersCategoryType"));
        customersCategories1.setCustomersCategoryDiscount(resultSet.getBoolean("CustomersCategoryDiscount"));
        return customersCategories1;
    }
    @Override
    public CustomersCategories getById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customersCategories WHERE idcustomersCategories=" + id);
            if (resultSet.next()) {
                logger.info(getCustomersCategoriesById(resultSet));
                return getCustomersCategoriesById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomersCategories> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customersCategories");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customersCategories.add(getCustomersCategoriesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customersCategories;
    }

    @Override
    public void add(int id, String customersCategoryType, boolean customersCategoryDiscount) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customersCategories VALUE(default, ?, ?)");
            preparedStatement.setString(1, customersCategoryType);
            preparedStatement.setBoolean(2, customersCategoryDiscount);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void update(CustomersCategories customersCategories) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customersCategories SET customersCategoryType=?, " +
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
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customersCategories " +
                    "WHERE idcustomersCategories=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
