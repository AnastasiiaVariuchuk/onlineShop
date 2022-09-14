package onlineShop.taskSAX;

import onlineShop.models.places.Countries;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandlerCountries extends DefaultHandler {
    private final List<Countries> countriesList= new ArrayList<>();
    private Countries countries;
    boolean isName = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("country")) {
            countries = new Countries();
            String id = attributes.getValue("id");
            countries.setIdCountry(Integer.parseInt(id));
        } else if (qName.equalsIgnoreCase("name")) {
            isName = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("country")) {
            countriesList.add(countries);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (isName) {
            countries.setCountryName(new String(chars, start, length));
            isName = false;
        }
    }

    public List<Countries> getList() {
        return countriesList;
    }
}
