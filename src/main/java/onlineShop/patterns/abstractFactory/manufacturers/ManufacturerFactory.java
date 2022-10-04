package onlineShop.patterns.abstractFactory.manufacturers;

import onlineShop.patterns.abstractFactory.AbstractFactory;
import onlineShop.patterns.abstractFactory.clients.Profitability;

public class ManufacturerFactory extends AbstractFactory {
    public IManufacturer getManufacturer(String manufacturer) {
        if (manufacturer == null) {
            return null;
        } else if (manufacturer.equalsIgnoreCase("Apple")) {
            return new Apple();
        } else  if (manufacturer.equalsIgnoreCase("Dior")) {
            return new Dior();
        }
        return null;
    }

    @Override
    public Profitability getProfitability(String profitability) {
        return null;
    }
}
