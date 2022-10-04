package onlineShop.patterns.abstractFactory;

import onlineShop.patterns.abstractFactory.clients.ProfitabilityFactory;
import onlineShop.patterns.abstractFactory.manufacturers.ManufacturerFactory;

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
