package Decorator;

public class Main{
    public static void main(String[]args){
        /*Coffee c = new Coffee(true,true,false);
        System.out.println(c.getCost());
        System.out.println(c.getDescription());

        SimpleCoffee sco = new SimpleCoffee();
        System.out.println(sco.getDescription());
        System.out.println(sco.getCost());

         */

        Beverage beverage = new SimpleCoffee();
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());
        beverage = new MilkDecorator(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());


    }

}
