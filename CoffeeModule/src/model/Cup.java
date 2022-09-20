package model;

public class Cup {

    private double cupSize;
    private Coffee coffee;

    public Cup(Coffee coffee, double cupSize) {
        this.cupSize = cupSize;
        this.coffee = coffee;
    }

    public void reFill(Coffee coffee) {
        this.coffee = coffee;
    }

    public String toString() {
        return coffee.toString();
    }

}
