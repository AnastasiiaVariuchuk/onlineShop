package onlineShop.models.people;

import java.util.Objects;

public class CustomersCategories {
    private int idCustomersCategory;
    private String customersCategoryType;
    private boolean customersCategoryDiscount;

    public CustomersCategories() {
    }

    public CustomersCategories(int idCustomersCategory, String customersCategoryType, boolean customersCategoryDiscount) {
        this.idCustomersCategory = idCustomersCategory;
        this.customersCategoryType = customersCategoryType;
        this.customersCategoryDiscount = customersCategoryDiscount;
    }

    public int getIdCustomersCategory() {
        return idCustomersCategory;
    }

    public void setIdCustomersCategory(int idCustomersCategory) {
        this.idCustomersCategory = idCustomersCategory;
    }

    public String getCustomersCategoryType() {
        return customersCategoryType;
    }

    public void setCustomersCategoryType(String customersCategoryType) {
        this.customersCategoryType = customersCategoryType;
    }

    public boolean isCustomersCategoryDiscount() {
        return customersCategoryDiscount;
    }

    public void setCustomersCategoryDiscount(boolean customersCategoryDiscount) {
        this.customersCategoryDiscount = customersCategoryDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersCategories that = (CustomersCategories) o;
        return idCustomersCategory == that.idCustomersCategory && customersCategoryDiscount == that.customersCategoryDiscount && customersCategoryType.equals(that.customersCategoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomersCategory, customersCategoryType, customersCategoryDiscount);
    }

    @Override
    public String toString() {
        return "CustomersCategories{" +
                "idCustomersCategory=" + idCustomersCategory +
                ", customersCategoryType='" + customersCategoryType + '\'' +
                ", customersCategoryDiscount=" + customersCategoryDiscount +
                '}';
    }
}
