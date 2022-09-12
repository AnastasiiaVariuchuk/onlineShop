package onlineShop.dao.idbcMySQLImpl.iproducts;

import onlineShop.models.products.ProductCategories;
import onlineShop.models.products.Products;

import java.util.List;

public interface IProductsDAO {
    Products getById(int id);

    List<Products> getAll();

    void add(int id, String productName, String productDescription, int idProductCategory,
             float productPrice, int idManufacturer, int idDiscount);

    void update(Products products);

    void delete(int id);
}
