package onlineShop.patterns.abstractFactory.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LegalEntity extends Profitability {
    private static final Logger logger = LogManager.getLogger(LegalEntity.class);
    @Override
    public void buyShares(double numberOfShares) {
        logger.info("Buy shares as an legal entity " + numberOfShares);
    }
}
