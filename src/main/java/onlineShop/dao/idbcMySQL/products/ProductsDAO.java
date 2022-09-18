package onlineShop.dao.idbcMySQL.products;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.iproducts.IProductsDAO;
import onlineShop.models.products.Products;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductsDAO implements IProductsDAO {
    private static final Logger logger = LogManager.getLogger(Products.class);
    private Products getProductsById(ResultSet resultSet) throws SQLException {
        Products products1 = new Products();
        products1.setIdProduct(resultSet.getInt("idproduct"));
        products1.setProductName(resultSet.getString("productName"));
        products1.setProductDescription(resultSet.getString("productDescription"));
        products1.setIdProductCategory(resultSet.getInt("idproductCategorie"));
        products1.setProductPrice(resultSet.getFloat("productPrice"));
        products1.setIdManufacturer(resultSet.getInt("idmanufacturer"));
        products1.setIdDiscount(resultSet.getInt("iddiscount"));
        return products1;
    }
    @Override
    public Products getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products WHERE idProduct=" + id);
            if (resultSet.next()) {
                logger.info(getProductsById(resultSet));
                return getProductsById(resultSet);
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
    public List<Products> getAll() {
        List<Products> products= new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(getProductsById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return products;
    }

    @Override
    public void add(Products products) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO products VALUE(default, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, products.getProductName());
            preparedStatement.setString(2, products.getProductDescription());
            preparedStatement.setInt(3, products.getIdProductCategory());
            preparedStatement.setFloat(4, products.getProductPrice());
            preparedStatement.setInt(5, products.getIdManufacturer());
            preparedStatement.setInt(6, products.getIdDiscount());
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
    public void update(Products products) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE products SET productName=?, " +
                    "productName=?, productDescription=?, idProductCategorie=?, productPrice=?, idmanufacturer=?, iddiscount=? WHERE idproduct=?");
            preparedStatement.setString(1, products.getProductName());
            preparedStatement.setString(2, products.getProductDescription());
            preparedStatement.setInt(3, products.getIdProductCategory());
            preparedStatement.setFloat(4, products.getProductPrice());
            preparedStatement.setInt(5, products.getIdManufacturer());
            preparedStatement.setInt(6, products.getIdDiscount());
            preparedStatement.setInt(7, products.getIdProduct());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + products.getIdProduct() + " " + products.getProductName());
            } else
                logger.info("Update process was failed: " + products.getIdProduct() + " " + products.getProductName());
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
            preparedStatement = connection.prepareStatement("DELETE FROM products " +
                    "WHERE idproduct=" + id);
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
