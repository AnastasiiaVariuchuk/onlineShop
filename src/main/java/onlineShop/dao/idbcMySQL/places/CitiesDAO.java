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
    List<Cities> cities = new LinkedList<>();

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
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cities WHERE idcity=" + id);
            if (resultSet.next()) {
                logger.info(getCityById(resultSet));
                return getCityById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cities> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cities");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(getCityById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void add(int id, String cityName, String cityPostalCode, int idCountry) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, cityName);
            preparedStatement.setString(2, cityPostalCode);
            preparedStatement.setInt(3, idCountry);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Cities cities) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cities SET cityName=?, " +
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
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cities WHERE idcity=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
