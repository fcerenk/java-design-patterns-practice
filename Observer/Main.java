package Observer;

public class Main{
public static void main(String[] args) {
    WeatherStation weatherStation = new WeatherStation();
    //weatherStation.setTemperature(27.0);
    //weatherStation.setTemperature(29.5);

    ConsoleDisplay console = new ConsoleDisplay();
    WebDisplay web = new WebDisplay();
    PhoneDisplay phone = new PhoneDisplay();
    SmartWatchDisplay smartWatch = new SmartWatchDisplay();
    weatherStation.addObserver(console);
    weatherStation.addObserver(web);
    weatherStation.addObserver(phone);
    weatherStation.addObserver(smartWatch);

    weatherStation.setTemperature(25.7);

    weatherStation.removeObserver(phone);
    weatherStation.setTemperature(27.8);



}

}
