package Observer;

public class PhoneDisplay implements Observer {
    @Override
    public void update(double temperature){
        System.out.println("Phone: " + temperature);
    }
}
