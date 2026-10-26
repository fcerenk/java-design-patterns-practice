# Factory Pattern: Notification System

## The Problem
Without the pattern, every place that needs a notification creates it with
its own if/else block and `new` calls. This means the creation logic is
copied in many places, and each place must know all concrete classes.
Adding a new type means finding and changing every copy.

## The Solution
I created a `Notification` interface with a `send(String message)` method.
It works like a contract: every notification type must follow it.
`NotificationFactory.create(type)` creates the right object and returns it
as a `Notification`. Now the main class does not need to know which concrete
class is used. It only asks the factory for a notification and calls `send`.
The if/else chain still exists, but only inside the factory. The rest of
the code does not know how objects are created.****

## How to Run
Run `Main`, then type SMS, EMAIL, PUSH or WHATSAPP.
Invalid input (for example FAX or null) throws an `IllegalArgumentException`.

## The Extension Test (WhatsApp)
To add WhatsApp, I created 1 new class and added 1 line in the factory.
`Main.java` did not change at all. With the old if/else version, I would
have to update every copy of the block.

## Design Decisions
- `create` is `static` because the factory has no state, so there is no
  reason to create a factory object.
- For null or unknown types I throw an exception instead of returning null.
  This way the problem is visible immediately and not hidden until a
  NullPointerException happens later.

## When NOT to Use It
A factory is overkill when there is only one class, or when the types will
never change. In that case, a simple `new` is clearer.