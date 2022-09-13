package be.abis.courseadmin.model;

public class Service {

    private static final double price = 5.0;

    public double calculatePrice() {
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

    /* protected double calculatePrice() {
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    } */

}
