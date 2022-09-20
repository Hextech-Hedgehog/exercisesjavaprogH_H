package model;

public class Student extends Person {

    private int yearNumber;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void printInfo() {
        System.out.println(this.getClass().getSimpleName() + ": "+ this.getFirstName() + " " + this.getLastName());
    }

    public Cup fetchCoffee(CoffeeType ct, double milkAmount, int sugar, double cupSize) {
        Coffee coffee = CoffeeMachine.selectCoffee(ct);
        CoffeeMachine.addMilk(coffee, milkAmount);
        CoffeeMachine.addSugar(coffee, sugar);
        return CoffeeMachine.pourCoffee(coffee, cupSize);
    }

}
