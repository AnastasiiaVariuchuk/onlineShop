package onlineShop.taskSAX;

import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class Executor {
    private static final Logger logger = (Logger) LogManager.getLogger(Executor.class);

    public static void main(String[] args) {
        var runner = new SaxParserRunner();
        List<Countries> lines = runner.parseCountries();

        lines.forEach(logger::info);
    }
}
