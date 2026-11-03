package Strategy;

public class VipDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total*0.8;
    }
}
