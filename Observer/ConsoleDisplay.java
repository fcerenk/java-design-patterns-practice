package Observer;

public class ConsoleDisplay implements Observer {

    @Override
    public void update(double temperature){
        System.out.println("Console: " + temperature);
    }
}
