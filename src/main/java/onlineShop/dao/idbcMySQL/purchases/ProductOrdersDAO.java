package onlineShop.dao.idbcMySQL.purchases;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.ipurchases.IProductOrdersDAO;
import onlineShop.models.purchases.ProductOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductOrdersDAO implements IProductOrdersDAO {
    private static final Logger logger = LogManager.getLogger(ProductOrdersDAO.class);
    private ProductOrders getProductOrdersById(ResultSet resultSet) throws SQLException {
        ProductOrders productOrders1 = new ProductOrders();
        productOrders1.setIdProductOrder(resultSet.getInt("idproductOrder"));
        productOrders1.setIdProduct(resultSet.getInt("idproduct"));
        productOrders1.setIdShoppingOrder(resultSet.getInt("idshoppingOrder"));
        return productOrders1;
    }
    @Override
    public ProductOrders getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM productorders WHERE idproductOrder=" + id);
            if (resultSet.next()) {
                logger.info(getProductOrdersById(resultSet));
                return getProductOrdersById(resultSet);
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
    public List<ProductOrders> getAll() {
        List<ProductOrders> productOrders = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM productorders");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productOrders.add(getProductOrdersById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return productOrders;
    }

    @Override
    public void add(ProductOrders productOrders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO productorders VALUE(default, ?, ?)");
            preparedStatement.setInt(1, productOrders.getIdProduct());
            preparedStatement.setInt(2, productOrders.getIdShoppingOrder());
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
    public void update(ProductOrders productOrders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE productorders SET idproduct=?, " +
                    "idshoppingOrder=? WHERE idproductOrder=?");
            preparedStatement.setInt(1, productOrders.getIdProduct());
            preparedStatement.setInt(2, productOrders.getIdShoppingOrder());
            preparedStatement.setInt(3, productOrders.getIdProductOrder());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + productOrders.getIdProductOrder());
            } else
                logger.info("Update process was failed: " + productOrders.getIdProductOrder());
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
            preparedStatement = connection.prepareStatement("DELETE FROM productorders " +
                    "WHERE idproductOrder=" + id);
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
