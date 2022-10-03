package onlineShop.services.patterns.abstractFactory.clients;

import onlineShop.services.patterns.abstractFactory.manufacturers.IManufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class Profitability {
    private static final Logger logger = LogManager.getLogger(Profitability.class);
    protected double numberOfShares;
    public abstract void buyShares(double numberOfShares);

    public void calculateProfitability(double numberOfShares, double marketPriceOfAShare, IManufacturer manufacturer) {
        //Дивидeнднaя дoxoднocть = (Cуммa дивидeндoв зa гoд/ Pынoчнaя цeнa aкции) x 100%
        double dividendProfitability = (numberOfShares/marketPriceOfAShare) * 100;
        logger.info(dividendProfitability + "%");
        logger.info("Your investment: " + numberOfShares * manufacturer.getSharePrice() + "$");
    }
}
