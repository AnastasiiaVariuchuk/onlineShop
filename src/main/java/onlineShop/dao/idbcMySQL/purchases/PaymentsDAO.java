package onlineShop.dao.idbcMySQL.purchases;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipurchases.IPaymentsDAO;
import onlineShop.models.purchases.Discounts;
import onlineShop.models.purchases.Payments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class PaymentsDAO implements IPaymentsDAO {
    private static final Logger logger = LogManager.getLogger(PaymentsDAO.class);
    private Payments getPaymentsById(ResultSet resultSet) throws SQLException {
        Payments payments1 = new Payments();
        payments1.setIdPayment(resultSet.getInt("idpayment"));
        payments1.setIdCustomer(resultSet.getInt("idcustomer"));
        payments1.setPaymentDateTime(resultSet.getTimestamp("paymentDateTime"));
        payments1.setPaymentStatus(resultSet.getBoolean("paymentStatus"));
        return payments1;
    }
    @Override
    public Payments getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM payments WHERE idpayment=" + id);
            if (resultSet.next()) {
                logger.info(getPaymentsById(resultSet));
                return getPaymentsById(resultSet);
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
    public List<Payments> getAll() {
        List<Payments> payments = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM payments");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                payments.add(getPaymentsById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return payments;
    }

    @Override
    public void add(Payments payments) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO payments VALUES(default, ?, ?, ?)");
            preparedStatement.setInt(1, payments.getIdCustomer());
            preparedStatement.setTimestamp(2, payments.getPaymentDateTime());
            preparedStatement.setBoolean(3, payments.isPaymentStatus());
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
    public void update(Payments payments) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE payments SET idcustomer=?, " +
                    "idpaymentDateTime=?, paymentStatus=? WHERE idpayment=?");
            preparedStatement.setInt(1, payments.getIdCustomer());
            preparedStatement.setTimestamp(2, payments.getPaymentDateTime());
            preparedStatement.setBoolean(3, payments.isPaymentStatus());
            preparedStatement.setInt(4, payments.getIdPayment());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + payments.getIdPayment() + " " + payments.getIdCustomer());
            } else
                logger.info("Update process was failed: " + payments.getIdPayment() + " " + payments.getIdCustomer());
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
            preparedStatement = connection.prepareStatement("DELETE FROM payments " +
                    "WHERE idpayment=" + id);
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
