package be.abis.acc.model;

import java.util.HashMap;
import java.util.Map;

public class Course {

    private String name;
    private int duration;
    private double dailyPrice;
    private boolean requiresExperience;


    public Course(String name, int duration, double dailyPrice, boolean requiresExperience) {
        this.name = name;
        this.duration = duration;
        this.dailyPrice = dailyPrice;
        this.requiresExperience = requiresExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public boolean isRequiresExperience() {
        return requiresExperience;
    }

    public void setRequiresExperience(boolean requiresExperience) {
        this.requiresExperience = requiresExperience;
    }

    public double calculateTotalPrice() {
        double result = this.dailyPrice * this.duration;
        result *= this.duration < 3 && !this.requiresExperience? (1- 0.21) : 1;
        return result;
    }

    public String labelPrice() {
        HashMap<String, Double> prices = new HashMap<>(){{
            put("CHEAP", 500.0);
            put("OK", 1500.0);
            put("EXPENSIVE", Double.MAX_VALUE);
        }};
        String label = "This course affordability is ";
        double price = this.calculateTotalPrice();

        if (price < (double)prices.get("CHEAP"))
            label += "CHEAP";
        else if (price < (double)prices.get("OK"))
            label += "OK";
        else
            label += "EXPENSIVE";

        return label;
    }

    public void printInfo() {
        System.out.print("The " + this.name + " course takes " + this.duration + " days. Prior knowledge is ");
        if (!this.requiresExperience)
            System.out.print("not ");
        System.out.print("required. The total price is " + this.calculateTotalPrice());
        System.out.println(". " + this.labelPrice());
    }
}
