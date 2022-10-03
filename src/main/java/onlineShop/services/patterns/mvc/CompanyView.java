package onlineShop.services.patterns.mvc;

import onlineShop.services.identification.SingUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyView {
    private static final Logger logger = LogManager.getLogger(CompanyView.class);
    public void printDetails (int id, String name, double sharePrice){
        logger.info("Company Details: ");
        logger.info("ID: " + id);
        logger.info("Name: " + name);
        logger.info("Share prise: " + sharePrice);
    }
}
