package onlineShop.models.people;

import java.util.Objects;

public class Customers {
    private int idCustomer;
    private String customerName;
    private String customerSurname;
    private String customerCard;
    private String customerPhoneNumber;
    private int idCustomerCategory;

    public Customers() {
    }

    public Customers(int idCustomer, String customerName, String customerSurname, String customerCard,
                     String customerPhoneNumber, int idCustomerCategory) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerCard = customerCard;
        this.customerPhoneNumber = customerPhoneNumber;
        this.idCustomerCategory = idCustomerCategory;
    }

    public Customers(String customerName, String customerSurname, String customerCard,
                     String customerPhoneNumber, int idCustomerCategory) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerCard = customerCard;
        this.customerPhoneNumber = customerPhoneNumber;
        this.idCustomerCategory = idCustomerCategory;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerCard() {
        return customerCard;
    }

    public void setCustomerCard(String customerCard) {
        this.customerCard = customerCard;
    }

    public String getCustomerPhoneNumber() {
        return this.customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getIdCustomerCategory() {
        return idCustomerCategory;
    }

    public void setIdCustomerCategory(int idCustomerCategory) {
        this.idCustomerCategory = idCustomerCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return idCustomer == customers.idCustomer && idCustomerCategory == customers.idCustomerCategory && customerName.equals(customers.customerName) && customerSurname.equals(customers.customerSurname) && customerCard.equals(customers.customerCard) && customerPhoneNumber.equals(customers.customerPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, customerName, customerSurname, customerCard, customerPhoneNumber, idCustomerCategory);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "idCustomer=" + idCustomer +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerCard='" + customerCard + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", idCustomerCategory=" + idCustomerCategory +
                '}';
    }
}
