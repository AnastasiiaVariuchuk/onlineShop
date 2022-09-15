package onlineShop.dao.idbcMySQL.purchases;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipurchases.IDeliveriesDAO;
import onlineShop.models.purchases.Deliveries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class DeliveriesDAO implements IDeliveriesDAO {
    private static final Logger logger = LogManager.getLogger(DeliveriesDAO.class);
    private Deliveries getDeliveriesById(ResultSet resultSet) throws SQLException {
        Deliveries deliveries1 = new Deliveries();
        deliveries1.setIdDelivery(resultSet.getInt("iddelivery"));
        deliveries1.setIdAddress(resultSet.getInt("idaddresse"));
        deliveries1.setIdUser(resultSet.getInt("iduser"));
        deliveries1.setDeliveryDataTime(resultSet.getTimestamp("deliveryDateTime"));
        deliveries1.setIdEmployee(resultSet.getInt("idemployee"));
        return deliveries1;
    }
    @Override
    public Deliveries getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM deliveries WHERE iddelivery=" + id);
            if (resultSet.next()) {
                logger.info(getDeliveriesById(resultSet));
                return getDeliveriesById(resultSet);
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
    public List<Deliveries> getAll() {
        List<Deliveries> deliveries = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM deliveries");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                deliveries.add(getDeliveriesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return deliveries;
    }

    @Override
    public void add(int id, int idAddress, int idUser, LocalDateTime deliveryDataTime, int idEmployee) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO manufacturers VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setInt(1, idAddress);
            preparedStatement.setInt(2, idUser);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(deliveryDataTime));
            preparedStatement.setInt(4, idEmployee);
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
    public void add(Deliveries deliveries) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO manufacturers VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setInt(1, deliveries.getIdAddress());
            preparedStatement.setInt(2, deliveries.getIdUser());
            preparedStatement.setTimestamp(3, deliveries.getDeliveryDataTime());
            preparedStatement.setInt(4, deliveries.getIdEmployee());
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
    public void update(Deliveries deliveries) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE deliveries SET idaddresse=?, " +
                    "iduser=?, deliveryDateTime=?, idemployee=? WHERE iddeliveryr=?");
            preparedStatement.setInt(1, deliveries.getIdAddress());
            preparedStatement.setInt(2, deliveries.getIdUser());
            preparedStatement.setTimestamp(3, deliveries.getDeliveryDataTime());
            preparedStatement.setInt(4, deliveries.getIdEmployee());
            preparedStatement.setInt(5, deliveries.getIdDelivery());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + deliveries.getIdDelivery());
            } else
                logger.info("Update process was failed: " + deliveries.getIdDelivery());
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
            preparedStatement = connection.prepareStatement("DELETE FROM deliveries " +
                    "WHERE iddelivery=" + id);
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
