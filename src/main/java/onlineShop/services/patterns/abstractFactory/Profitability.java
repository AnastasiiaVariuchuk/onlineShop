package onlineShop.services.patterns.abstractFactory;

import onlineShop.services.delivery.AddLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class Profitability {
    private static final Logger logger = LogManager.getLogger(Profitability.class);
    protected double rate;

    abstract void getInterestRate(double rate);

    public void calculateProfitability(double dividendAmount, double marketPriceOfAShare) {
        //Дивидeнднaя дoxoднocть = (Cуммa дивидeндoв зa гoд/ Pынoчнaя цeнa aкции) x 100%
        double dividendProfitability = (dividendAmount/marketPriceOfAShare) * 100;
        logger.info(dividendProfitability);
    }
}
