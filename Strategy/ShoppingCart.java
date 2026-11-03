package Strategy;

public class ShoppingCart {
    private double total;
    private DiscountStrategy discountStrategy;


    public ShoppingCart(double total, DiscountStrategy discountStrategy) {
        this.total=total;
        this.discountStrategy=discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy=discountStrategy;
    }


    public double calculateFinalPrice(){
           // if (customerType.equalsIgnoreCase("REGULAR")){ return total;}
            //else if(customerType.equalsIgnoreCase("STUDENT")){ return total*0.9;}
            //else if(customerType.equalsIgnoreCase("VIP")){return total*0.8;}

           // else if (customerType.equalsIgnoreCase("EMPLOYEE")){ return total*0.7;}
            //so ahrd to add new functionality if-else block , for example need to be added 10 new function?!
            //else{
              //  throw new IllegalArgumentException("Invalid customer type: "+customerType);
            //}
        // unreachable statement  return price;

        return discountStrategy.applyDiscount(total);
    }
}
