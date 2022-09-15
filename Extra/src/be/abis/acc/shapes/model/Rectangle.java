package be.abis.acc.shapes.model;

import java.awt.*;

public class Rectangle extends Shape {

    private double height, width;

    public Rectangle(double height, double width, Color color, Point point) {
        super(color, point);
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return this.height * this.width;
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }
}
