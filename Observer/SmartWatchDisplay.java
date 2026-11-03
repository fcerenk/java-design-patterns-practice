package Observer;

public class SmartWatchDisplay implements Observer {
    @Override
    public void update(double temperature) {
        System.out.println("SmartWatch Temperature: " + temperature);
    }
}
