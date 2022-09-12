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
    List<Products> products= new LinkedList<>();
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
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE idProduct=" + id);
            if (resultSet.next()) {
                logger.info(getProductsById(resultSet));
                return getProductsById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Products> getAll() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(getProductsById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void add(int id, String productName, String productDescription, int idProductCategory, float productPrice,
                    int idManufacturer, int idDiscount) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products VALUE(default, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productDescription);
            preparedStatement.setInt(3, idProductCategory);
            preparedStatement.setFloat(4, productPrice);
            preparedStatement.setInt(5, idManufacturer);
            preparedStatement.setInt(6, idDiscount);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insertion is successful.");
            } else
                logger.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Products products) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET productName=?, " +
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
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products " +
                    "WHERE idproduct=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete process is successful.");
            } else
                logger.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
