package onlineShop.models.products;

import java.util.Objects;

public class Manufacturers {
    private int idManufacturer;
    private String manufacturerName;
    private String manufacturerContact;

    public Manufacturers() {
    }

    public Manufacturers(int idManufacturer, String manufacturerName, String manufacturerContact) {
        this.idManufacturer = idManufacturer;
        this.manufacturerName = manufacturerName;
        this.manufacturerContact = manufacturerContact;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerContact() {
        return manufacturerContact;
    }

    public void setManufacturerContact(String manufacturerContact) {
        this.manufacturerContact = manufacturerContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturers that = (Manufacturers) o;
        return idManufacturer == that.idManufacturer && manufacturerName.equals(that.manufacturerName) && manufacturerContact.equals(that.manufacturerContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManufacturer, manufacturerName, manufacturerContact);
    }

    @Override
    public String toString() {
        return "Manufacturers{" +
                "idManufacturer=" + idManufacturer +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerContact='" + manufacturerContact + '\'' +
                '}';
    }
}
