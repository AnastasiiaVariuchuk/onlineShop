package onlineShop.patterns.abstractFactory;

import onlineShop.patterns.abstractFactory.clients.Profitability;
import onlineShop.patterns.abstractFactory.manufacturers.IManufacturer;

public abstract class AbstractFactory {
    public abstract IManufacturer getManufacturer(String manufacturer);
    public abstract Profitability getProfitability(String profitability);
}
