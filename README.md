# java-design-patterns-practice

Today, I worked on the Singleton pattern. I built small Logger project.
Problem: Without Singleton, each service created its own Logger, so the log counter was not shared. With multiple threads , even basic Singleton created two instances.
Solution: Private constructor plus getInstance() method. For thread-safe safety I tried eager initialization and synchronized.
What I learned : Thread bugs depend on timing, so they don't always show up, and the safety comes from the code's logic, not from testing alone.