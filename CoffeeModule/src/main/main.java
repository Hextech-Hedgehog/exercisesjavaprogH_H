package main;

import model.CoffeeType;
import model.Instructor;
import model.Person;
import model.Student;

public class main {

    public static void main(String[] args) {
        Person Sebastian = new Student("Sebastian", "Michaelis");
        Person ciel = new Instructor("Ciel", "Starlight", "001");
        ((Instructor)ciel).askForCoffee((Student)Sebastian, CoffeeType.CAPPUCCINO, 200, 5, 700);
    }

}
