package model;

public class Instructor extends Person {

    private String teacherId;

    public Instructor(String firstName, String lastName, String teacherId) {
            super(firstName, lastName);
            this.teacherId = teacherId;
    }

    public void printInfo() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + " is a teacher.");
    }

    public void teaches() {
        throw new UnsupportedOperationException("no existing courses implemented");
    }

    public void askForCoffee(Student s, CoffeeType ct, double milkAmount, int sugars, double cupSize) {
        Cup cupOfCoffee = s.fetchCoffee(ct, milkAmount, sugars, cupSize);
    }

}
