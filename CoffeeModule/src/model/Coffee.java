package model;

public class Coffee {

    private CoffeeType coffeeType;
    private int sugar;
    private double milk;

    public Coffee(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    protected void addSuggar(int amount) {
        this.sugar += amount;
    }

    protected void addMilk(double volume) {
        this.milk += volume;
    }

    public double getVolume() {
        return this.coffeeType.getVolume() + this.milk;
    }

    public double getCoffeeVolume() {
        return this.coffeeType.getCoffeeVolume();
    }

    public double getMilkVolume() {
        return this.coffeeType.getMilkVolume() + this.milk;
    }

    public int getSugar() {
        return this.sugar;
    }

    public String toString() {
        String extraSugar = this.sugar > 0 ? "\tWith extra sugars: " + this.sugar : "";
        String extraMilk = this.milk > 0 ? "milk: " + this.milk : "";
        String extras = extraMilk.length() > 0 ? extraSugar + " and extra " + extraMilk : "";
        return this.getClass().getSimpleName() + " " + this.coffeeType.toString() + extras;
    }

}
