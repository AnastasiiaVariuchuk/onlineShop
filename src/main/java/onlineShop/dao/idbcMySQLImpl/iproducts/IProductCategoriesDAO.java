package onlineShop.dao.idbcMySQLImpl.iproducts;

import onlineShop.models.products.ProductCategories;


import java.util.List;

public interface IProductCategoriesDAO {
    ProductCategories getById(int id);

    List<ProductCategories> getAll();

    void add(int id, String productCategoryName);

    void update(ProductCategories productCategories);

    void delete(int id);
}
