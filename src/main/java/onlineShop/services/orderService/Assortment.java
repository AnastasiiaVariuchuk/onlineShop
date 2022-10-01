package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.products.ProductCategoriesDAO;
import onlineShop.dao.idbcMySQL.products.ProductsDAO;
import onlineShop.models.products.ProductCategories;
import onlineShop.models.products.Products;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assortment {
    private static final Logger logger = LogManager.getLogger(Assortment.class);

    public static ProductCategories chooseProductCategory() {
        ProductCategoriesDAO productCategoriesDAO = new ProductCategoriesDAO();
        Scanner scanner = new Scanner(System.in);
        boolean status = false;
        int input = 0;
        do {
            productCategoriesDAO.getAll().forEach(logger::info);
            logger.info("Choose product category");
            input = scanner.nextInt();
            if (productCategoriesDAO.getById(input) != null) {
                status = true;
            } else {
                logger.info("Please, product category from the list!");
            }
        } while (!status);
        return productCategoriesDAO.getById(input);
    }

    public static Products chooseProduct(ProductCategories productCategories) {
        ProductsDAO productsDAO = new ProductsDAO();
        Scanner scanner = new Scanner(System.in);
        boolean status = false;
        int input = 0;
        do {
            List<Products> products = productsDAO.getAll().stream()
                    .filter(products1 -> products1.getIdProductCategory() == productCategories.getIdProductCategory())
                    .collect(Collectors.toList());
            products.forEach(logger::info);
            logger.info("Choose product");
            input = scanner.nextInt();
            if (productsDAO.getById(input) != null) {
                status = true;
            } else {
                logger.info("Please, product from the list!");
            }
        } while (!status);
        return productsDAO.getById(input);
    }
}
