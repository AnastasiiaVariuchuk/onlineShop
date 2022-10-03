package onlineShop.services.patterns.abstractFactory;

import onlineShop.services.patterns.abstractFactory.clients.Profitability;
import onlineShop.services.patterns.abstractFactory.clients.ProfitabilityFactory;
import onlineShop.services.patterns.abstractFactory.manufacturers.ManufacturerFactory;

public class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Manufacturer")){
            return new ManufacturerFactory();
        } else if(choice.equalsIgnoreCase("Client")){
            return new ProfitabilityFactory();
        }
        return null;
    }
}
