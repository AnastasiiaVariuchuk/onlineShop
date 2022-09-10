package onlineShop.models.purchases;

import java.util.Objects;

public class ProductOrders {
    private int idProductOrder;
    private int idProduct;
    private int idShoppingOrder;

    public ProductOrders() {
    }

    public ProductOrders(int idProductOrder, int idProduct, int idShoppingOrder) {
        this.idProductOrder = idProductOrder;
        this.idProduct = idProduct;
        this.idShoppingOrder = idShoppingOrder;
    }

    public int getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(int idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdShoppingOrder() {
        return idShoppingOrder;
    }

    public void setIdShoppingOrder(int idShoppingOrder) {
        this.idShoppingOrder = idShoppingOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrders that = (ProductOrders) o;
        return idProductOrder == that.idProductOrder && idProduct == that.idProduct && idShoppingOrder == that.idShoppingOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductOrder, idProduct, idShoppingOrder);
    }

    @Override
    public String toString() {
        return "ProductOrders{" +
                "idProductOrder=" + idProductOrder +
                ", idProduct=" + idProduct +
                ", idShoppingOrder=" + idShoppingOrder +
                '}';
    }
}
