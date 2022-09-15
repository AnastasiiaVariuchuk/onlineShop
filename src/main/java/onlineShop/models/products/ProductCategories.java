package onlineShop.models.products;

import java.util.Objects;

public class ProductCategories {
    private int idProductCategory;
    private String productCategoryName;

    public ProductCategories() {
    }

    public ProductCategories(int idProductCategory, String productCategoryName) {
        this.idProductCategory = idProductCategory;
        this.productCategoryName = productCategoryName;
    }

    public ProductCategories(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public int getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(int idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategories that = (ProductCategories) o;
        return idProductCategory == that.idProductCategory && Objects.equals(productCategoryName, that.productCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductCategory, productCategoryName);
    }

    @Override
    public String toString() {
        return "ProductCategories{" +
                "idProductCategory=" + idProductCategory +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }
}
