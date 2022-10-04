package onlineShop.patterns.abstractFactory.clients;

import onlineShop.patterns.abstractFactory.AbstractFactory;
import onlineShop.patterns.abstractFactory.manufacturers.IManufacturer;

public class ProfitabilityFactory extends AbstractFactory {
    @Override
    public IManufacturer getManufacturer(String manufacturer) {
        return null;
    }

    @Override
    public Profitability getProfitability(String profitability) {
        if (profitability == null) {
            return null;
        } else if (profitability.equalsIgnoreCase("Individual")) {
            return new Individual();
        } else  if (profitability.equalsIgnoreCase("LegalEntity")) {
            return new LegalEntity();
        }
        return null;
    }
}
