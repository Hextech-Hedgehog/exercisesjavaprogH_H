package model;

public class PublicSession extends Session {

    public PublicSession(Course course) {
        super(course, "ABIS");
    }

    @Override
    public double calculatePrice() {
        double price = 300.0;
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }
}
