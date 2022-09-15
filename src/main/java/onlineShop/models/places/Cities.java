package onlineShop.models.places;

public class Cities {
    private int idCity;
    private String cityName;
    private String cityPostalCode;
    private int idCountry;

    public Cities() {
    }

    public Cities(int idCity, String cityName, String cityPostalCode, int idCountry) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.cityPostalCode = cityPostalCode;
        this.idCountry = idCountry;
    }

    public Cities(String cityName, String cityPostalCode, int idCountry) {
        this.cityName = cityName;
        this.cityPostalCode = cityPostalCode;
        this.idCountry = idCountry;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityPostalCode() {
        return cityPostalCode;
    }

    public void setCityPostalCode(String cityPostalCode) {
        this.cityPostalCode = cityPostalCode;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", cityPostalCode='" + cityPostalCode + '\'' +
                ", idCountry=" + idCountry +
                '}';
    }
}
