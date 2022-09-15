package onlineShop.dao.idbcMySQL.places;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.iplaces.IAddressesDAO;
import onlineShop.models.places.Addresses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;


public class AddressesDAO implements IAddressesDAO {
    private static final Logger logger = LogManager.getLogger(AddressesDAO.class);
    private Addresses getAddressById(ResultSet resultSet) throws SQLException {
        Addresses newAddress = new Addresses();
        newAddress.setIdAddress(resultSet.getInt("idaddresse"));
        newAddress.setAddressName(resultSet.getString("addresseName"));
        newAddress.setAddressPostalCode(resultSet.getString("addressePostalCode"));
        newAddress.setIdCity(resultSet.getInt("idcity"));
        return newAddress;
    }

    @Override
    public Addresses getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM addresses WHERE idaddresse=" + id);
            if (resultSet.next()) {
                logger.info(getAddressById(resultSet));
                return getAddressById(resultSet);
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
    public List<Addresses> getAll() {
        List<Addresses> addresses = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM addresses");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addresses.add(getAddressById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return addresses;
    }

    @Override
    public void add(int id, String addressName, String addressPostalCode, int idCity) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO addresses VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, addressName);
            preparedStatement.setString(2, addressPostalCode);
            preparedStatement.setInt(3, idCity);
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
    public void add(Addresses addresses) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO addresses VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, addresses.getAddressName());
            preparedStatement.setString(2, addresses.getAddressPostalCode());
            preparedStatement.setInt(3, addresses.getIdCity());
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
    public void update(Addresses addresses) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE addresses SET addresseName=?, " +
                    "addressePostalCode=?, idcity=? WHERE idaddreses=?");
            preparedStatement.setString(1, addresses.getAddressName());
            preparedStatement.setString(2, addresses.getAddressPostalCode());
            preparedStatement.setInt(3, addresses.getIdCity());
            preparedStatement.setInt(4, addresses.getIdAddress());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + addresses.getIdAddress() + "-" + addresses.getAddressName());
            } else
                logger.info("Update process was failed: " + addresses.getIdAddress() + "-" + addresses.getAddressName());
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
            preparedStatement = connection.prepareStatement("DELETE FROM addresses WHERE idaddresse=" + id);
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
