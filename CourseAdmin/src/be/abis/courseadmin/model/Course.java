package be.abis.courseadmin.model;

import java.util.stream.Stream;

public class Course {

    private String title;
    private int period;
    private double dailyPrice;

    public Course(String title, int period, double dailyPrice) {
        this.title = title;
        this.period = period;
        this.dailyPrice = dailyPrice;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getDailyPrice() {
        return this.dailyPrice;
    }

    public void setDailyPrice(double price) {
        this.dailyPrice = price;
    }

    public void printInfo() {
        System.out.println("Current course name :" + this.title + ", duration: " + this.period + " , price for one day: " + this.dailyPrice);
    }

    public double calculateTotalPrice() {
        return period * dailyPrice;
    }

    public double calculateTotalPrice(double reduction) {
        return this.calculateTotalPrice() * (1 - reduction / 100);
    }

}
