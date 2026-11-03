package Decorator;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;
    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
