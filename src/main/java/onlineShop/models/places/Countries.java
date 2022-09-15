package onlineShop.models.places;

import java.util.Objects;

public class Countries {
    private int idCountry;
    private String countryName;

    public Countries() {
    }

    public Countries(int idCountry, String countryName) {
        this.idCountry = idCountry;
        this.countryName = countryName;
    }

    public Countries(String countryName) {
        this.countryName = countryName;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return idCountry == countries.idCountry && countryName.equals(countries.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, countryName);
    }

    @Override
    public String toString() {
        return "Countries{" +
                "idCountry=" + idCountry +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
