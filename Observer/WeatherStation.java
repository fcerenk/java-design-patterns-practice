package Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    private double temperature;
    //private PhoneDisplay phoneDisplay;
    //private WebDisplay webDisplay;
    //private ConsoleDisplay consoleDisplay;
    private List<Observer> observers = new ArrayList<>(); // observer pattern

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature);
        }
    }

    public WeatherStation() {
        //this.phoneDisplay = new PhoneDisplay();
        //this.webDisplay = new WebDisplay();
        //this.consoleDisplay = new ConsoleDisplay();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
       // phoneDisplay.update(temperature);
        //webDisplay.update(temperature);
        //consoleDisplay.update(temperature);
        notifyObservers();
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        //weatherStation.setTemperature(27.0);
        //weatherStation.setTemperature(29.5);

        ConsoleDisplay console = new ConsoleDisplay();
        WebDisplay web = new WebDisplay();
        PhoneDisplay phone = new PhoneDisplay();
        weatherStation.addObserver(console);
        weatherStation.addObserver(web);
        weatherStation.addObserver(phone);

        weatherStation.setTemperature(25.7);

        weatherStation.removeObserver(phone);
        weatherStation.setTemperature(27.8);



    }


}
