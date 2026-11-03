# Observer Pattern: Weather Station

A small Java project that shows the Observer pattern. A weather station measures the temperature, and several displays (console, web, phone, smartwatch) are updated automatically when the temperature changes.

## The Problem

In my first version, `WeatherStation` knew every display by name. It had one field for each display and called each `update` method by hand:

```java
private PhoneDisplay phone = new PhoneDisplay();
private WebDisplay web = new WebDisplay();
private ConsoleDisplay console = new ConsoleDisplay();

public void setTemperature(double temperature) {
    this.temperature = temperature;
    phone.update(temperature);
    web.update(temperature);
    console.update(temperature);
}
```

This works, but it has problems:

- To add a new display (for example a smartwatch), I have to open `WeatherStation` and add a new field, a new `new`, and a new `update` call.
- To remove a display, I have to open `WeatherStation` again.
- The station should only measure the temperature. It should not care who is listening.

## The Solution

I created an `Observer` interface with one method: `update(double temperature)`. It works like a contract: every display that wants to listen must follow it.

`WeatherStation` no longer has one field per display. It keeps a `List<Observer>` and has three methods:

- `addObserver(Observer)`: a display subscribes
- `removeObserver(Observer)`: a display unsubscribes
- `notifyObservers()`: the station goes through the list and calls `update` on every observer

When `setTemperature` is called, the station saves the new value and calls `notifyObservers()`. The station does not know which displays are in the list. It only knows that all of them have an `update` method.

A simple way to think about it is a YouTube channel: the channel does not know each subscriber personally. It just notifies everyone who subscribed.

## Project Structure

- `Observer.java`: the interface (the contract)
- `WeatherStation.java`: the subject, keeps the list of observers and notifies them
- `ConsoleDisplay.java`, `WebDisplay.java`, `PhoneDisplay.java`: observers
- `SmartWatchDisplay.java`: a new observer added later to test the pattern

## How to Run

Run the `main` method. It creates the station and three displays, subscribes them, changes the temperature, then unsubscribes the phone and changes the temperature again.

Example output:

```
Console: 25.7
Web: 25.7
Phone: 25.7
Console: 27.8
Web: 27.8
```

After `removeObserver(phone)`, the phone display does not receive the second update.

## The Extension Test (SmartWatch)

To test the pattern, I added `SmartWatchDisplay`:

- I created 1 new class that implements `Observer`.
- I added 2 lines in `main` to create it and subscribe it to the station.
- The `WeatherStation` class itself (its fields and methods) did not change.

With my first version, the same change would need a new field, a new `new`, and a new `update` call inside `WeatherStation`.

## Design Decisions

- **`List<Observer>` and not `List<PhoneDisplay>`:** the station should depend on the interface, not on concrete classes. If the list held only `PhoneDisplay` objects, no other display could be added.
- **Keeping displays in variables:** at first, `removeObserver` did not work for me because I added the display with `addObserver(new PhoneDisplay())` and tried to remove a different `new PhoneDisplay()`. These are two different objects, so the list found nothing to remove. I fixed it by saving the display in a variable and using the same variable for add and remove.

## When NOT to Use It

- When there is only one listener and it will never change. A direct method call is simpler.
- When there are many observers, every change notifies all of them. If one observer is slow, the others have to wait.
- When the order of notifications matters, because this simple version does not guarantee a useful order.
