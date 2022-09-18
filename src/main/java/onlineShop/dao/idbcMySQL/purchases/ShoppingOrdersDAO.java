package onlineShop.dao.idbcMySQL.purchases;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipurchases.IShoppingOrdersDAO;
import onlineShop.models.purchases.ShoppingOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ShoppingOrdersDAO implements IShoppingOrdersDAO {
    private static final Logger logger = LogManager.getLogger(ShoppingOrdersDAO.class);
    private ShoppingOrders getShoppingOrdersById(ResultSet resultSet) throws SQLException {
        ShoppingOrders shoppingOrders1 = new ShoppingOrders();
        shoppingOrders1.setIdShoppingOrder(resultSet.getInt("idshoppingOrder"));
        shoppingOrders1.setShoppingOrderDate(resultSet.getDate("shoppingOrderDate"));
        shoppingOrders1.setShoppingOrderTotalPrice(resultSet.getDouble("shoppingOrderTotalPrice"));
        shoppingOrders1.setIdUser(resultSet.getInt("idUser"));
        return shoppingOrders1;
    }
    @Override
    public ShoppingOrders getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM shoppingOrders WHERE idshoppingOrder=" + id);
            if (resultSet.next()) {
                logger.info(getShoppingOrdersById(resultSet));
                return getShoppingOrdersById(resultSet);
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
    public List<ShoppingOrders> getAll() {
        List<ShoppingOrders> shoppingOrders = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM shoppingOrders");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                shoppingOrders.add(getShoppingOrdersById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return shoppingOrders;
    }

    @Override
    public void add(ShoppingOrders shoppingOrders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO shoppingOrders VALUE(default, ?, ?, ?)");
            preparedStatement.setDate(1, (java.sql.Date) shoppingOrders.getShoppingOrderDate());
            preparedStatement.setDouble(2, shoppingOrders.getShoppingOrderTotalPrice());
            preparedStatement.setInt(3, shoppingOrders.getIdUser());
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
    public void update(ShoppingOrders shoppingOrders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE shoppingOrders SET shoppingOrderDate=?, " +
                    "shoppingOrderDate=?, shoppingOrderTotalPrice=?, iduser=? WHERE idproductOrder=?");
            preparedStatement.setDate(1, (java.sql.Date) shoppingOrders.getShoppingOrderDate());
            preparedStatement.setDouble(2, shoppingOrders.getShoppingOrderTotalPrice());
            preparedStatement.setInt(3, shoppingOrders.getIdUser());
            preparedStatement.setInt(3, shoppingOrders.getIdShoppingOrder());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + shoppingOrders.getIdShoppingOrder() + " " + shoppingOrders.getIdUser());
            } else
                logger.info("Update process was failed: " + shoppingOrders.getIdShoppingOrder() + " " + shoppingOrders.getIdUser());
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
            preparedStatement = connection.prepareStatement("DELETE FROM shoppingOrders " +
                    "WHERE idshoppingOrder=" + id);
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
