package be.abis.acc.shapes.model;

import java.awt.*;

public class Line extends Shape{

    private double length;

    public Line(double length, Color color, Point point) {
        super(color, point);
        this.length = length;
    }

    public double area() {
        return 0.0;
    }

}
