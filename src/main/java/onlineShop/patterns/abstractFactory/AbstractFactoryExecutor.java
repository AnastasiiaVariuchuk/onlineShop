package onlineShop.patterns.abstractFactory;

import onlineShop.patterns.abstractFactory.clients.Profitability;
import onlineShop.patterns.abstractFactory.manufacturers.IManufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryExecutor {
    private static final Logger logger = LogManager.getLogger(AbstractFactoryExecutor.class);
    public static void main(String args[])throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        logger.info("Enter the name of Manufacturer from where you want to buy shares(Apple or Dior): ");
        String ManufacturerName = bufferedReader.readLine();

        logger.info("Enter your client type(Individual or LegalEntity): ");
        String clientType = bufferedReader.readLine();

        AbstractFactory mfactory = FactoryCreator.getFactory("Manufacturer");
        IManufacturer manufacturer = mfactory.getManufacturer(ManufacturerName);
        AbstractFactory pfactory = FactoryCreator.getFactory("Client");
        Profitability profitability = pfactory.getProfitability(clientType);

        logger.info("Enter count of shares you want to buy: " + manufacturer.getManufactureName() + ": ");
        double numberOfShares = Double.parseDouble(bufferedReader.readLine());

        profitability.calculateProfitability(numberOfShares, manufacturer.getSharePrice(), manufacturer);
        profitability.buyShares(numberOfShares);
    }
}
