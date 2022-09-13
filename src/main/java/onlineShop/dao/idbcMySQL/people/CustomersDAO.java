package onlineShop.dao.idbcMySQL.people;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipeople.ICustomersDAO;
import onlineShop.models.people.Customers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {
    private static final Logger logger = LogManager.getLogger(CustomersDAO.class);
    List<Customers> customers = new LinkedList<>();

    private Customers getCustomersById(ResultSet resultSet) throws SQLException {
        Customers customers1 = new Customers();
        customers1.setIdCustomer(resultSet.getInt("idcustomer"));
        customers1.setCustomerName(resultSet.getString("customerName"));
        customers1.setCustomerSurname(resultSet.getString("customerSurname"));
        customers1.setCustomerCard(resultSet.getString("customerCard"));
        customers1.setCustomerPhoneNumber(resultSet.getString("customerPhoneNumber"));
        customers1.setIdCustomerCategory(resultSet.getInt("idcustomerCategory"));
        return customers1;
    }
    @Override
    public Customers getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE idcustomers=" + id);
            if (resultSet.next()) {
                logger.info(getCustomersById(resultSet));
                return getCustomersById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Customers> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(getCustomersById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return customers;
    }

    @Override
    public void add(int id, String customerName, String customerSurname, String customerCard, String customerPhoneNumber, int idCustomerCategory) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO customers VALUE(default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, customerSurname);
            preparedStatement.setString(3, customerCard);
            preparedStatement.setString(4, customerPhoneNumber);
            preparedStatement.setInt(5, idCustomerCategory);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void update(Customers customers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE customers SET customerName=?, " +
                    "customerSurname=?, customerCard=?, customerPhoneNumber=?, idcustomerCategory=? WHERE idcustomer=?");
            preparedStatement.setString(1, customers.getCustomerName());
            preparedStatement.setString(2, customers.getCustomerSurname());
            preparedStatement.setString(3, customers.getCustomerCard());
            preparedStatement.setString(4, customers.getCustomerPhoneNumber());
            preparedStatement.setInt(5, customers.getIdCustomerCategory());
            preparedStatement.setInt(6, customers.getIdCustomer());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + customers.getCustomerName() + customers.getCustomerSurname());
            } else
                logger.info("Update process was failed: " + customers.getCustomerName() + customers.getCustomerSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM customers " +
                    "WHERE idcustomer=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
