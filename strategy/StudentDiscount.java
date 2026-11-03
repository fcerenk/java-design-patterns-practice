package strategy;

public class StudentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total*0.9;
    }
}
