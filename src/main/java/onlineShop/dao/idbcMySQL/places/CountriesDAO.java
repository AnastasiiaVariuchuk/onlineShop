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
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM countries WHERE idcountry=" + id);
            if (resultSet.next()) {
                logger.info(getCountryById((resultSet)));
                return getCountryById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
    public List<Countries> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM countries");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countries.add(getCountryById(resultSet));
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
        return countries;
    }

    @Override
    public void add(int id, String countryName) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO countries VALUE(default, ?)");
            preparedStatement.setString(1, countryName);
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
    public void update(Countries countries) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE countries SET countryName=?" +
                    "WHERE idcountry=?");
            preparedStatement.setString(1, countries.getCountryName());
            preparedStatement.setInt(2, countries.getIdCountry());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + countries.getIdCountry() + "-" + countries.getCountryName());
            } else
                logger.info("Update process was failed: " + countries.getIdCountry() + "-" + countries.getCountryName());
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
            preparedStatement = connection.prepareStatement("DELETE FROM countries WHERE idcountry=" + id);
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
