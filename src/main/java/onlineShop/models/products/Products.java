package onlineShop.models.products;

import java.util.Objects;

public class Products {
    private int idProduct;
    private String productName;
    private String productDescription;
    private int idProductCategory;
    private float productPrice;
    private int idManufacturer;
    private int idDiscount;

    public Products() {
    }

    public Products(int idProduct, String productName, String productDescription, int idProductCategory,
                    float productPrice, int idManufacturer, int idDiscount) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
        this.idProductCategory = idProductCategory;
        this.productPrice = productPrice;
        this.idManufacturer = idManufacturer;
        this.idDiscount = idDiscount;
    }

    public Products(String productName, String productDescription, int idProductCategory,
                    float productPrice, int idManufacturer, int idDiscount) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.idProductCategory = idProductCategory;
        this.productPrice = productPrice;
        this.idManufacturer = idManufacturer;
        this.idDiscount = idDiscount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(int idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return idProduct == products.idProduct && idProductCategory == products.idProductCategory && Float.compare(products.productPrice, productPrice) == 0 && idManufacturer == products.idManufacturer && idDiscount == products.idDiscount && productName.equals(products.productName) && productDescription.equals(products.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, productName, productDescription, idProductCategory, productPrice, idManufacturer, idDiscount);
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", idProductCategory=" + idProductCategory +
                ", productPrice=" + productPrice +
                ", idManufacturer=" + idManufacturer +
                ", idDiscount=" + idDiscount +
                '}';
    }
}
