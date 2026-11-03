# Decorator Pattern: Coffee Shop

A small Java project that shows the Decorator pattern. A coffee order can get extra items (milk, chocolate, syrup) as layers, and each layer changes the description and the price without changing the original coffee class.

## The Problem

In my first version, one `Coffee` class had a `boolean` for every extra item:

```java
public Coffee(boolean milk, boolean chocolate, boolean syrup) { ... }

public double getCost() {
    double cost = 5.0;
    if (milk) cost += 1.0;
    if (chocolate) cost += 1.5;
    if (syrup) cost += 0.5;
    return cost;
}
```

This works for a few extras, but it has problems:

- To add a new extra (for example whipped cream), I have to change the fields, the constructor, `getCost` and `getDescription`. Every place that calls `new Coffee(true, true, false)` must also change, because the number of parameters changes.
- A `boolean` can only say yes or no. A customer cannot ask for double milk.
- The other option is one class for every combination (`CoffeeWithMilk`, `CoffeeWithMilkAndChocolate`, ...), but the number of classes grows very fast.

## The Solution

I created a `Beverage` interface that every drink follows:

```java
public interface Beverage {
    String getDescription();
    double getCost();
}
```

- `SimpleCoffee` is the plain coffee in the center.
- `BeverageDecorator` is an abstract class. It is a `Beverage`, and it also holds another `Beverage` inside.
- `MilkDecorator`, `ChocolateDecorator` and `SyrupDecorator` extend `BeverageDecorator`. Each one asks the beverage inside for its description and cost, and then adds its own part:

```java
public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.0;
    }
}
```

Layers are added in `main` by wrapping the same variable again and again:

```java
Beverage beverage = new SimpleCoffee();
beverage = new MilkDecorator(beverage);
beverage = new ChocolateDecorator(beverage);
```

A simple way to think about it is a matryoshka doll: the coffee is in the center, and each decorator is a new layer around it. Java does the same in its I/O classes, for example `new BufferedReader(new FileReader("a.txt"))`.

## Project Structure

- `Beverage.java`: the interface (the contract)
- `SimpleCoffee.java`: the plain coffee
- `BeverageDecorator.java`: abstract base for all decorators
- `MilkDecorator.java`, `ChocolateDecorator.java`, `SyrupDecorator.java`: the layers
- `Coffee.java`: my first version without the pattern, kept for comparison
- `Main.java`: builds an order layer by layer

## How to Run

Run the `main` method in `Main.java`. It starts with a plain coffee and wraps it with decorators. After each layer, it prints the description and the price.

## Design Decisions

- **The variable type is `Beverage`:** the same variable can hold a plain coffee or a coffee with many layers, because every layer is also a `Beverage`.
- **A decorator is a `Beverage` and also has a `Beverage`:** this is what makes the layers possible. Because of the "is a" part, a decorator can be wrapped by another decorator. Because of the "has a" part, it can use what is inside.
- **No fixed base price in the decorators:** each decorator uses `beverage.getCost()` of the object inside and adds its own amount. Only `SimpleCoffee` knows the base price of 5.0.
- **`protected` field in `BeverageDecorator`:** the child classes need to reach the beverage inside. With `private` they could not.
- **`super(beverage)` in every decorator:** it passes the object to the parent class, which stores it. Without it, the layer would lose the coffee inside.

## When NOT to Use It

- When there are only a few fixed combinations. A simple class or an enum can be clearer.
- When there are many layers, there are many small classes and the code is harder to follow.
- When the order of layers matters, the result can be confusing, and debugging a deep stack of layers is harder than debugging one class.