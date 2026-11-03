package Strategy;

public class Main {
    public static void main(String[]args){
        /*ShoppingCart cart = new ShoppingCart(100);
        System.out.println(cart.calculateFinalPrice("VIP"));

        System.out.println(cart.calculateFinalPrice("STUDENT"));

        System.out.println(cart.calculateFinalPrice("REGULAR"));

         */
        ShoppingCart cart = new ShoppingCart(100,new NoDiscount());
        System.out.println(cart.calculateFinalPrice());

        cart.setDiscountStrategy(new StudentDiscount());
        System.out.println(cart.calculateFinalPrice());

        cart.setDiscountStrategy(new VipDiscount());
        System.out.println(cart.calculateFinalPrice());

        cart.setDiscountStrategy(new EmployeeDiscount());
        System.out.println(cart.calculateFinalPrice());



    }
}
