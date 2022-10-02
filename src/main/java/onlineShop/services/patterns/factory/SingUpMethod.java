package onlineShop.services.patterns.factory;

import onlineShop.services.identification.Registration;
import onlineShop.services.identification.SingUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingUpMethod implements ServiceManager{
    private static final Logger logger = LogManager.getLogger(SingUpMethod.class);

    @Override
    public void createServiceManager() {
        boolean success = SingUp.entry();
        logger.info("Sing up status " + success);
    }
}
