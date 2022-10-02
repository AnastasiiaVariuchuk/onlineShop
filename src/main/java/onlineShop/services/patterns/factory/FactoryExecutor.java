package onlineShop.services.patterns.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryExecutor {
    private static final Logger logger = LogManager.getLogger(FactoryExecutor.class);
    public static void main(String[] args) {
        ServiceManagerFactory serviceManagerFactory = new ServiceManagerFactory();

        ServiceManager registration = serviceManagerFactory.getServiceManager("Registration");
        registration.createServiceManager();

        ServiceManager singUp = serviceManagerFactory.getServiceManager("SingUp");
        singUp.createServiceManager();
    }
}
