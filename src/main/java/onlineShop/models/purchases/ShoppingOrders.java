package onlineShop.models.purchases;

import java.util.Date;
import java.util.Objects;


public class ShoppingOrders {
    private int idShoppingOrder;
    private Date shoppingOrderDate;
    private double shoppingOrderTotalPrice;
    private int idUser;

    public ShoppingOrders() {
    }

    public ShoppingOrders(int idShoppingOrder, Date shoppingOrderDate, double shoppingOrderTotalPrice, int idUser) {
        this.idShoppingOrder = idShoppingOrder;
        this.shoppingOrderDate = shoppingOrderDate;
        this.shoppingOrderTotalPrice = shoppingOrderTotalPrice;
        this.idUser = idUser;
    }

    public ShoppingOrders(Date shoppingOrderDate, double shoppingOrderTotalPrice, int idUser) {
        this.shoppingOrderDate = shoppingOrderDate;
        this.shoppingOrderTotalPrice = shoppingOrderTotalPrice;
        this.idUser = idUser;
    }

    public int getIdShoppingOrder() {
        return idShoppingOrder;
    }

    public void setIdShoppingOrder(int idShoppingOrder) {
        this.idShoppingOrder = idShoppingOrder;
    }

    public Date getShoppingOrderDate() {
        return shoppingOrderDate;
    }

    public void setShoppingOrderDate(Date shoppingOrderDate) {
        this.shoppingOrderDate = shoppingOrderDate;
    }

    public double getShoppingOrderTotalPrice() {
        return shoppingOrderTotalPrice;
    }

    public void setShoppingOrderTotalPrice(double shoppingOrderTotalPrice) {
        this.shoppingOrderTotalPrice = shoppingOrderTotalPrice;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingOrders that = (ShoppingOrders) o;
        return idShoppingOrder == that.idShoppingOrder && Double.compare(that.shoppingOrderTotalPrice, shoppingOrderTotalPrice) == 0 && idUser == that.idUser && Objects.equals(shoppingOrderDate, that.shoppingOrderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShoppingOrder, shoppingOrderDate, shoppingOrderTotalPrice, idUser);
    }

    @Override
    public String toString() {
        return "ShoppingOrders{" +
                "idShoppingOrder=" + idShoppingOrder +
                ", shoppingOrderDate=" + shoppingOrderDate +
                ", shoppingOrderTotalPrice=" + shoppingOrderTotalPrice +
                ", idUser=" + idUser +
                '}';
    }
}
