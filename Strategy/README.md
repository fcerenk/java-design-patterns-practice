
# Strategy Pattern: Shopping Cart Discounts

A small Java project that shows the Strategy pattern. A shopping cart calculates the final price, and the discount rule can be changed while the program is running.

## The Problem

In my first version, `ShoppingCart` calculated the discount with an if/else chain inside one method:

```java
public double calculateFinalPrice(String customerType) {
    if (customerType.equalsIgnoreCase("REGULAR")) { return total; }
    else if (customerType.equalsIgnoreCase("STUDENT")) { return total * 0.9; }
    else if (customerType.equalsIgnoreCase("VIP")) { return total * 0.8; }
    else { throw new IllegalArgumentException("Invalid customer type: " + customerType); }
}
```

This works, but every new customer type (for example EMPLOYEE) means opening `ShoppingCart` and making this method longer. All discount rules are mixed in one place. It is hard to test one rule alone, and a mistake in one branch can break the others. With 10 customer types, the method would have 10 branches.

## The Solution

I moved each discount rule into its own class. All of them follow one interface:

```java
public interface DiscountStrategy {
    double applyDiscount(double total);
}
```

`ShoppingCart` now keeps a `DiscountStrategy` as a field and does not know which concrete discount it uses:

```java
public double calculateFinalPrice() {
    return discountStrategy.applyDiscount(total);
}
```

There is no if/else in `ShoppingCart` anymore. The discount can also be changed at runtime with `setDiscountStrategy(...)`, so the same cart object can give different results.

A simple way to think about it is a navigation app: the destination is the same, but you choose the way (car, walking, public transport). The app does not have one huge if/else for all of them. Each way is a separate Strategy.

## Project Structure

- `DiscountStrategy.java`: the interface (the contract)
- `NoDiscount.java`, `StudentDiscount.java`, `VipDiscount.java`: the strategies
- `EmployeeDiscount.java`: a new Strategy added later to test the pattern
- `ShoppingCart.java`: the context, it uses a Strategy but does not know which one
- `Main.java`: creates a cart and switches strategies

## How to Run

Run the `main` method in `Main.java`. It creates a cart with a total of 100, calculates the price with each Strategy, and prints the result. The same cart object gives different prices when the Strategy is changed with `setDiscountStrategy`.

## The Extension Test (Employee)

To test the pattern, I added a 30% discount for employees:

- I created 1 new class, `EmployeeDiscount`, that implements `DiscountStrategy`.
- I did not change `ShoppingCart.java` or `DiscountStrategy.java`.

With my first version, the same change would need a new `else if` inside `calculateFinalPrice`, so I would have to edit the cart class again.

## Design Decisions

- **The field type is `DiscountStrategy`, not a concrete class:** `ShoppingCart` depends only on the interface. If the field were `StudentDiscount`, no other discount could be used.
- **Strategy can be changed at runtime:** I added `setDiscountStrategy` so the same cart can switch the discount without creating a new cart.
- **`applyDiscount` returns the price after the discount:** the cart does not need to know how the number is calculated.

## When NOT to Use It

- When there are only one or two rules that will never change. A simple if/else is clearer in that case.
- When the client has to choose a Strategy, it must know the differences between them. For a user with no such knowledge, more classes can make the code harder to follow.
- Each Strategy is a new class, so a very large number of tiny strategies can make the project harder to navigate.