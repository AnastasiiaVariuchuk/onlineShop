package onlineShop.taskSAX;

import onlineShop.models.places.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class SaxParserRunner {
    private static final Logger logger = LogManager.getLogger(SaxParserRunner.class);
    private SAXParser saxParser = null;

    private SAXParser create() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxParser = factory.newSAXParser();
            return saxParser;
        } catch (ParserConfigurationException | SAXException e) {
            logger.info(e.getMessage());
            return saxParser;
        }
    }

    public List<Countries> parseCountries() {
        var handler = new SaxParserHandlerCountries();
        String fileName = "src/main/java/onlineShop/taskSAX/Countries.xml";
        File xmlDocument = Paths.get(fileName).toFile();

        try {
            SAXParser parser = create();
            parser.parse(xmlDocument, handler);
        } catch (SAXException | IOException e) {
            logger.info(e.getMessage());
        }
        return handler.getList();
    }
}
