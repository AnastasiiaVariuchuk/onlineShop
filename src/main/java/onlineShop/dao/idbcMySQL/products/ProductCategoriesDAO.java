package onlineShop.dao.idbcMySQL.products;

import onlineShop.ConnectionUtil;
import onlineShop.dao.idbcMySQLImpl.iproducts.IProductCategoriesDAO;
import onlineShop.models.products.ProductCategories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductCategoriesDAO implements IProductCategoriesDAO {
    private static final Logger logger = LogManager.getLogger(ProductCategoriesDAO.class);
    private ProductCategories getProductCategoriesById(ResultSet resultSet) throws SQLException {
        ProductCategories productCategories1 = new ProductCategories();
        productCategories1.setIdProductCategory(resultSet.getInt("idProductCategorie"));
        productCategories1.setProductCategoryName(resultSet.getString("ProductCategorieName"));
        return productCategories1;
    }

    @Override
    public ProductCategories getById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM productCategories WHERE idProductCategorie=" + id);
            if (resultSet.next()) {
                logger.info(getProductCategoriesById(resultSet));
                return getProductCategoriesById(resultSet);
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
    public List<ProductCategories> getAll() {
        List<ProductCategories> productCategories = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM productCategories");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productCategories.add(getProductCategoriesById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return productCategories;
    }

    @Override
    public void add(ProductCategories productCategories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO productCategories VALUE(default, ?)");
            preparedStatement.setString(1, productCategories.getProductCategoryName());
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
    public void update(ProductCategories productCategories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE productCategories SET productCategorieName=? " +
                    "WHERE idproductCategorie=?");
            preparedStatement.setString(1, productCategories.getProductCategoryName());
            preparedStatement.setInt(2, productCategories.getIdProductCategory());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update process is successful: " + productCategories.getProductCategoryName());
            } else
                logger.info("Update process was failed: " + productCategories.getProductCategoryName());
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
            preparedStatement = connection.prepareStatement("DELETE FROM productCategories " +
                    "WHERE idproductCategorie=" + id);
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
