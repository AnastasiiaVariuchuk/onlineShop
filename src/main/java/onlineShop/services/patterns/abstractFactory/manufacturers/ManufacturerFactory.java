package onlineShop.services.patterns.abstractFactory.manufacturers;

import onlineShop.services.patterns.abstractFactory.AbstractFactory;
import onlineShop.services.patterns.abstractFactory.clients.Profitability;
import onlineShop.services.patterns.abstractFactory.manufacturers.Apple;
import onlineShop.services.patterns.abstractFactory.manufacturers.Dior;
import onlineShop.services.patterns.abstractFactory.manufacturers.IManufacturer;

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
