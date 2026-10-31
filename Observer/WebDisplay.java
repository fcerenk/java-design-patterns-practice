package Observer;

public class WebDisplay implements Observer {

    @Override
    public void update(double temperature){
        System.out.println("Web: " + temperature);
    }
}
