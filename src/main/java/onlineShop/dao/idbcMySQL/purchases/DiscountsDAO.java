package onlineShop.dao.idbcMySQL.purchases;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipurchases.IDiscountsDAO;
import onlineShop.models.purchases.Discounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DiscountsDAO implements IDiscountsDAO {
    private static final Logger logger = LogManager.getLogger(DiscountsDAO.class);
    List<Discounts> discounts = new LinkedList<>();
    private Discounts getDiscountsById(ResultSet resultSet) throws SQLException {
        Discounts discounts1 = new Discounts();
        discounts1.setIdDiscount(resultSet.getInt("iddiscount"));
        discounts1.setDiscountSize(resultSet.getDouble("iddiscountSize"));
        return discounts1;
    }
    @Override
    public Discounts getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM discounts WHERE iddiscount=" + id);
            if (resultSet.next()) {
                logger.info(getDiscountsById(resultSet));
                return getDiscountsById(resultSet);
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
    public List<Discounts> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM discounts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                discounts.add(getDiscountsById(resultSet));
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
        return discounts;
    }

    @Override
    public void add(int id, double discountSize) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO discounts VALUE(default, ?)");
            preparedStatement.setDouble(1, discountSize);
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
    public void update(Discounts discounts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE discounts SET discountSize=? " +
                    "WHERE iddiscount=?");
            preparedStatement.setDouble(1, discounts.getDiscountSize());
            preparedStatement.setInt(2, discounts.getIdDiscount());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + discounts.getIdDiscount());
            } else
                logger.info("Update process was failed: " + discounts.getIdDiscount());
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
            preparedStatement = connection.prepareStatement("DELETE FROM discounts " +
                    "WHERE iddiscount=" + id);
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
