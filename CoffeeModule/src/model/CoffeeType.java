package model;

public enum CoffeeType {

    BLACK(350), CORTADO(100, 100), ESPRESSO(100), DOPPIO(200),
    LATTE(100, 200), CAPPUCCINO(150, 200);

    private double coffeeAmount;
    private double milkAmount;

    private CoffeeType(int coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
        this.milkAmount = 0;
    }

    private CoffeeType(int coffeeAmount, int milkAmount) {
        this(coffeeAmount);
        this.milkAmount = milkAmount;
    }

    public double getVolume() {
        return this.coffeeAmount + this.milkAmount;
    }

    public double getMilkVolume() {
        return this.milkAmount;
    }

    public double getCoffeeVolume() {
        return this.coffeeAmount;
    }

    public void displayContent() {
        System.out.println();
        System.out.println("Composition:");
        System.out.println("Coffee: " + this.getCoffeeVolume());
        System.out.println("Milk: " + this.getMilkVolume());
    }

    public String toString() {
        String composition = this.name() + "\n";
        composition += "Composition: \n";
        composition += "Coffee: " + this.getCoffeeVolume() + "\n";
        composition += "Milk: " + this.getMilkVolume() + "\n";
        return composition;
    }
}
