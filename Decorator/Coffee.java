package Decorator;

public class Coffee {
    private boolean milk;
    private boolean chocolate;
    private boolean syrup;

    public Coffee(boolean milk, boolean chocolate, boolean syrup) {
        this.milk = milk;
        this.chocolate = chocolate;
        this.syrup = syrup;
    }

    public String getDescription() {
        String description="Coffee";
        if (milk) {
            description += ", Milk";
        }
        else if (chocolate) {
            description += ", Chocolate";
        }
        else if (syrup) {
            description += ", Syrup";
        }
        return description;
    }


    public double getCost() {
        double cost = 5.0;
        if (milk) {
            return cost+1.0;
        }
        else if (chocolate) {
            return cost+1.5;
        }
        else if (syrup) {
            return cost+0.5;
        }
        return cost;

    }


}