package onlineShop.services.patterns.abstractFactory.manufacturers;

import onlineShop.services.patterns.abstractFactory.Manufacturer;

public class Dior implements Manufacturer {
    private final String NAME;

    public Dior(){
        NAME="DIOR";
    }

    @Override
    public String getManufactureName() {
        return NAME;
    }
}
