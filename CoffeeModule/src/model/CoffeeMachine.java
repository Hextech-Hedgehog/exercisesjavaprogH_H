package model;

public class CoffeeMachine {

    private static double coffeeVolume = 5000.0;
    private static double milkVolume = 2000.0;
    private static int sugars = 200;

    public static void fillMachine(double coffeeVolume, double milkVolume, int sugars) {
        CoffeeMachine.coffeeVolume = coffeeVolume;
        CoffeeMachine.milkVolume = milkVolume;
        CoffeeMachine.sugars = sugars;
    }

    public static boolean hasEnough(Coffee coffee) {
        return coffee.getCoffeeVolume() <= coffeeVolume || coffee.getMilkVolume() <= milkVolume;
    }

    public static Coffee selectCoffee(CoffeeType ct) {
        return new Coffee(ct);
    }

    public static void addSugar(Coffee c, int amount) {
        c.addSuggar(amount);
    }

    public static void addMilk(Coffee c, double volume) {
        c.addMilk(volume);
    }

    public static Cup pourCoffee(Coffee c, double cupSize) throws RuntimeException {
        System.out.println(c);
        if (!hasEnough(c)) {
            throw new RuntimeException("Coffee Machine contents are running low. Refill the machine.");
        }
        if (c.getVolume() > cupSize) {
            throw new RuntimeException("Cup content overflowing, bring a bigger cup or decrease content volume.");
        } else {
            CoffeeMachine.coffeeVolume -= c.getCoffeeVolume();
            CoffeeMachine.milkVolume -= c.getMilkVolume();
            CoffeeMachine.sugars -= c.getSugar();
            System.out.println("Coffee successfully poured");
            displayRemainingContents();
        }

        return new Cup(c, cupSize);
    }

    public static void displayRemainingContents() {
        System.out.println("Coffee remaining in ml: " + coffeeVolume + ". Milk remaining in ml: " + milkVolume + ". Sugars remaining: " + sugars);
    }

}
