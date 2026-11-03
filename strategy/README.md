# Strategy Pattern: Shopping Cart Discounts

## The Problem
In my first version, `ShoppingCart` calculated the discount with an if/else
chain inside one method:

    public double calculateFinalPrice(String customerType) {
        if (customerType.equals("REGULAR")) return total;
        else if (customerType.equals("STUDENT")) return total * 0.9;
        else if (customerType.equals("VIP")) return total * 0.8;
        else throw new IllegalArgumentException("Invalid customer type: " + customerType);
    }

This works, but every new customer type (for example EMPLOYEE) means opening
`ShoppingCart` and making this method longer. All discount rules are mixed in
one place, so it is hard to test one rule alone, and a mistake in one branch
can break the others.