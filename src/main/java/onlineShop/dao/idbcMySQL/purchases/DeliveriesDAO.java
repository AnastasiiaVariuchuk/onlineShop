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
    List<Deliveries> deliveries = new LinkedList<>();
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
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM deliveries WHERE iddelivery=" + id);
            if (resultSet.next()) {
                logger.info(getDeliveriesById(resultSet));
                return getDeliveriesById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Deliveries> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM deliveries");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                deliveries.add(getDeliveriesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    @Override
    public void add(int id, int idAddress, int idUser, LocalDateTime deliveryDataTime, int idEmployee) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturers VALUE(default, ?, ?, ?, ?)");
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
        }
    }

    @Override
    public void update(Deliveries deliveries) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE deliveries SET idaddresse=?, " +
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
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM deliveries " +
                    "WHERE iddelivery=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
