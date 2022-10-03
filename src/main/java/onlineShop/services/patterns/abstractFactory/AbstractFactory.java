package onlineShop.services.patterns.abstractFactory;

import onlineShop.services.patterns.abstractFactory.clients.Profitability;
import onlineShop.services.patterns.abstractFactory.manufacturers.IManufacturer;

public abstract class AbstractFactory {
    public abstract IManufacturer getManufacturer(String manufacturer);
    public abstract Profitability getProfitability(String profitability);
}
