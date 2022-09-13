package be.abis.courseadmin.model;

public final class Consultancy extends Service {

    @Override
    public final double calculatePrice() {
        double price = 150.0;
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

}
