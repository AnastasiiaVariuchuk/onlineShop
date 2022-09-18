package onlineShop.dao.idbcMySQL.places;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.iplaces.ICitiesDAO;
import onlineShop.models.places.Cities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;


public class CitiesDAO implements ICitiesDAO {
    private static final Logger logger = LogManager.getLogger(CitiesDAO.class);
    private Cities getCityById(ResultSet resultSet) throws SQLException {
        Cities cities1 = new Cities();
        cities1.setIdCity(resultSet.getInt("idcity"));
        cities1.setCityName(resultSet.getString("cityName"));
        cities1.setCityPostalCode(resultSet.getString("cityPostalCode"));
        cities1.setIdCountry(resultSet.getInt("idcountry"));
        return cities1;
    }

    @Override
    public Cities getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cities WHERE idcity=" + id);
            if (resultSet.next()) {
                logger.info(getCityById(resultSet));
                return getCityById(resultSet);
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
    public List<Cities> getAll() {
        List<Cities> cities = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cities");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(getCityById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return cities;
    }

    @Override
    public void add(Cities cities) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO cities VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, cities.getCityName());
            preparedStatement.setString(2, cities.getCityPostalCode());
            preparedStatement.setInt(3, cities.getIdCountry());
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
    public void update(Cities cities) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE cities SET cityName=?, " +
                    "cityPostalCode=?, idcountry=? WHERE idcity?");
            preparedStatement.setString(1, cities.getCityName());
            preparedStatement.setString(2, cities.getCityPostalCode());
            preparedStatement.setInt(3, cities.getIdCountry());
            preparedStatement.setInt(4, cities.getIdCity());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + cities.getIdCity() + "-" + cities.getCityName());
            } else
                logger.info("Update process was failed: " + cities.getIdCity() + "-" + cities.getCityName());
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
            preparedStatement = connection.prepareStatement("DELETE FROM cities WHERE idcity=" + id);
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
