package onlineShop.models.purchases;

import java.util.Objects;

public class Discounts {
    private int idDiscount;
    private double discountSize;

    public Discounts() {
    }

    public Discounts(int idDiscount, double discountSize) {
        this.idDiscount = idDiscount;
        this.discountSize = discountSize;
    }

    public Discounts(double discountSize) {
        this.discountSize = discountSize;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public double getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(double discountSize) {
        this.discountSize = discountSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discounts discounts = (Discounts) o;
        return idDiscount == discounts.idDiscount && Double.compare(discounts.discountSize, discountSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiscount, discountSize);
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "idDiscount=" + idDiscount +
                ", discountSize=" + discountSize +
                '}';
    }
}
