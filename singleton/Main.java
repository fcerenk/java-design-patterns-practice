package singleton;

public class Main {
    public static void main(String []args){
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        userService.createUser();
        orderService.craeteOrder();


        System.out.println(new UserService().instance == new OrderService().instance); // true
    }
}
