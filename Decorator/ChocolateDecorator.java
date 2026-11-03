package Decorator;

public class ChocolateDecorator extends BeverageDecorator {

    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+", Chocolate";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.0;
    }
}
