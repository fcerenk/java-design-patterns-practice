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



}
