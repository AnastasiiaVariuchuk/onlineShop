package onlineShop.dao.idbcMySQL.places;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.iplaces.ICountriesDAO;
import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CountriesDAO implements ICountriesDAO {
    private static final Logger logger = LogManager.getLogger(CountriesDAO.class);
    List<Countries> countries = new LinkedList<>();
    private Countries getCountryById(ResultSet resultSet) throws SQLException {
        Countries countries1 = new Countries();
        countries1.setIdCountry(resultSet.getInt("idcountry"));
        countries1.setCountryName(resultSet.getString("countryName"));
        return countries1;
    }
    @Override
    public Countries getById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM countries WHERE idcountry=" + id);
            if (resultSet.next()) {
                logger.info(getCountryById((resultSet)));
                return getCountryById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Countries> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM countries");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countries.add(getCountryById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void add(int id, String countryName) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO countries VALUE(default, ?)");
            preparedStatement.setString(1, countryName);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Countries countries) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE countries SET countryName=?, " +
                    "WHERE idcountry?");
            preparedStatement.setString(1, countries.getCountryName());
            preparedStatement.setInt(2, countries.getIdCountry());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + countries.getIdCountry() + "-" + countries.getCountryName());
            } else
                logger.info("Update process was failed: " + countries.getIdCountry() + "-" + countries.getCountryName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM countries WHERE idcountries=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
