package be.abis.acc.shapes.model;

import java.awt.*;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius, Color color, Point point) {
        super(color, point);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getRadius() {
        return radius;
    }
}
