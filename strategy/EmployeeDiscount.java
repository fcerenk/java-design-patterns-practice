package strategy;

public class EmployeeDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double total) {
        return total*0.7;
    }
}
