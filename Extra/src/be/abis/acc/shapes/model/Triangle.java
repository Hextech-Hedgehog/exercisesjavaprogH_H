package be.abis.acc.shapes.model;

import java.awt.*;

public class Triangle extends Shape {

    private double height, width;

    public Triangle(double width, double height, Color color, Point point) {
        super(color, point);
        this.height = height;
        this.width = width;
    }

    public double area() {
        return (this.width * this.height) / 2;
    }

}
