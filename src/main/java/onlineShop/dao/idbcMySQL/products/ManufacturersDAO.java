package onlineShop.dao.idbcMySQL.products;

import onlineShop.ConnectionUtil;;
import onlineShop.dao.idbcMySQLImpl.iproducts.IManufacturersDAO;
import onlineShop.models.products.Manufacturers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ManufacturersDAO implements IManufacturersDAO {
    private static final Logger logger = LogManager.getLogger(ManufacturersDAO.class);
    private Manufacturers getManufacturersById(ResultSet resultSet) throws SQLException {
        Manufacturers manufacturers1 = new Manufacturers();
        manufacturers1.setIdManufacturer(resultSet.getInt("idmanufacturer"));
        manufacturers1.setManufacturerName(resultSet.getString("manufacturerName"));
        manufacturers1.setManufacturerContact(resultSet.getString("manufacturerContact"));
        return manufacturers1;
    }
    @Override
    public Manufacturers getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM manufacturers WHERE idmanufacturer=" + id);
            if (resultSet.next()) {
                logger.info(getManufacturersById(resultSet));
                return getManufacturersById(resultSet);
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
    public List<Manufacturers> getAll() {
        List<Manufacturers> manufacturers = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM manufacturers");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                manufacturers.add(getManufacturersById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return manufacturers;
    }

    @Override
    public void add(Manufacturers manufacturers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO manufacturers VALUE(default, ?, ?)");
            preparedStatement.setString(1, manufacturers.getManufacturerName());
            preparedStatement.setString(2, manufacturers.getManufacturerContact());
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
    public void update(Manufacturers manufacturers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE manufacturers SET manufacturerName=?, " +
                    "manufacturerContact=?WHERE idmanufacturer=?");
            preparedStatement.setString(1, manufacturers.getManufacturerName());
            preparedStatement.setString(2, manufacturers.getManufacturerContact());
            preparedStatement.setInt(3, manufacturers.getIdManufacturer());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + manufacturers.getManufacturerName());
            } else
                logger.info("Update process was failed: " + manufacturers.getManufacturerContact());
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
            preparedStatement = connection.prepareStatement("DELETE FROM manufacturers " +
                    "WHERE idmanufacturer=" + id);
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
