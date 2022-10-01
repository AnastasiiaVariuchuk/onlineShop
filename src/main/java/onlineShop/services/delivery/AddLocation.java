package onlineShop.services.delivery;

import onlineShop.dao.idbcMySQL.places.AddressesDAO;
import onlineShop.dao.idbcMySQL.places.CitiesDAO;
import onlineShop.dao.idbcMySQL.places.CountriesDAO;
import onlineShop.models.places.Addresses;
import onlineShop.models.places.Cities;
import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddLocation {
    private static final Logger logger = LogManager.getLogger(AddLocation.class);
    public static Countries getCountry() {
        Scanner scanner = new Scanner(System.in);
        boolean countryStatus = false;
        CountriesDAO countriesDAO = new CountriesDAO();
        int countryInput = 0;
        do {
            logger.info("Choose country:");
            countriesDAO.getAll().forEach(logger::info);
            countryInput = scanner.nextInt();
            if (countriesDAO.getById(countryInput) != null) {
                countryStatus = true;
            } else {
                logger.info("Please, choose country from the list!");
            }
        } while (!countryStatus);
        return countriesDAO.getById(countryInput);
    }

    public static Cities getCity(Countries country) {
        Scanner scanner = new Scanner(System.in);
        boolean cityStatus = false;
        CitiesDAO citiesDAO = new CitiesDAO();
        int cityInput = 0;
        do {
            logger.info("Choose city:");
            List<Cities> cities = citiesDAO.getAll().stream()
                    .filter(cities1 -> cities1.getIdCountry() == country.getIdCountry()).collect(Collectors.toList());
            cities.forEach(logger::info);
            cityInput = scanner.nextInt();
            if (citiesDAO.getById(cityInput) != null) {
                cityStatus = true;
            } else {
                logger.info("Please, choose city from the list!");
            }
        } while (!cityStatus);
        return citiesDAO.getById(cityInput);
    }

    public static Addresses addAddress(Cities cities) {
        Scanner scanner = new Scanner(System.in);
        Addresses addresses = new Addresses();
        AddressesDAO addressesDAO = new AddressesDAO();
        long count = addressesDAO.getAll().stream().count();

        logger.info("Add your address: ");
        String addressInput = scanner.nextLine();
        logger.info("Add your postal code: ");
        String postalCodeInput = scanner.nextLine();

        addresses.setAddressName(addressInput);
        addresses.setAddressPostalCode(postalCodeInput);
        addresses.setIdCity(cities.getIdCity());
        addresses.setIdAddress((int) (count+1));
        addressesDAO.add(addresses);
        return addresses;
    }
}
