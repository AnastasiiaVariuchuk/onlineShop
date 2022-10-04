package onlineShop.patterns.abstractFactory.manufacturers;

public class Dior implements IManufacturer {
    private final String NAME;

    private final double SHARE_PRICE;

    public Dior() {
        NAME = "DIOR";
        SHARE_PRICE = 589.45;
    }

    @Override
    public String getManufactureName() {
        return NAME;
    }

    @Override
    public double getSharePrice() {
        return SHARE_PRICE;
    }
}
