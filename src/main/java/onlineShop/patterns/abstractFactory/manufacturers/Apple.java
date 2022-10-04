package onlineShop.patterns.abstractFactory.manufacturers;

public class Apple implements IManufacturer {
    private final String NAME;
    private final double SHARE_PRICE;

    public Apple() {
        NAME = "APPLE";
        SHARE_PRICE = 141.32;
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
