package onlineShop.models.places;

import java.util.Objects;

public class Addresses {
    private int idAddress;
    private String addressName;
    private String addressPostalCode;
    private int idCountry;

    public Addresses() {
    }

    public Addresses(int idAddress, String addressName, String addressPostalCode, int idCountry) {
        this.idAddress = idAddress;
        this.addressName = addressName;
        this.addressPostalCode = addressPostalCode;
        this.idCountry = idCountry;
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

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return idAddress == addresses.idAddress && idCountry == addresses.idCountry && addressName.equals(addresses.addressName) && addressPostalCode.equals(addresses.addressPostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, addressName, addressPostalCode, idCountry);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "idAddress=" + idAddress +
                ", addressName='" + addressName + '\'' +
                ", addressPostalCode='" + addressPostalCode + '\'' +
                ", idCountry=" + idCountry +
                '}';
    }
}
