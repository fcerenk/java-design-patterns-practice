package Singleton;

public class OrderService {
    Logger instance = Logger.getInstance();

    public void craeteOrder(){
        instance.log("order created ");
    }
}
