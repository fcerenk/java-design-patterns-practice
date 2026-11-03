package Decorator;

public class SyrupDecorator extends BeverageDecorator{
    public SyrupDecorator(Beverage beverage) {
        super(beverage);
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+", Syrup";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.5;
    }
}
