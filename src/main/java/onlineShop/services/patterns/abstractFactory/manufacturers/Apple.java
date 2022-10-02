package onlineShop.services.patterns.abstractFactory.manufacturers;

import onlineShop.services.patterns.abstractFactory.Manufacturer;

public class Apple implements Manufacturer {
    private final String NAME;

    public Apple() {
        NAME = "APPLE";
    }
    @Override
    public String getManufactureName() {
        return NAME;
    }
}
