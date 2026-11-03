package Decorator;

public class SimpleCoffee implements Beverage{
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
