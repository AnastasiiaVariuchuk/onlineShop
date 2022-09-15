package onlineShop.models.places;

import java.util.Objects;

public class Addresses {
    private int idAddress;
    private String addressName;
    private String addressPostalCode;
    private int idCity;

    public Addresses() {
    }

    public Addresses(int idAddress, String addressName, String addressPostalCode, int idCity) {
        this.idAddress = idAddress;
        this.addressName = addressName;
        this.addressPostalCode = addressPostalCode;
        this.idCity = idCity;
    }

    public Addresses(String addressName, String addressPostalCode, int idCity) {
        this.addressName = addressName;
        this.addressPostalCode = addressPostalCode;
        this.idCity = idCity;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCountry) {
        this.idCity = idCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return idAddress == addresses.idAddress && idCity == addresses.idCity && addressName.equals(addresses.addressName) && addressPostalCode.equals(addresses.addressPostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, addressName, addressPostalCode, idCity);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "idAddress=" + idAddress +
                ", addressName='" + addressName + '\'' +
                ", addressPostalCode='" + addressPostalCode + '\'' +
                ", idCountry=" + idCity +
                '}';
    }
}
