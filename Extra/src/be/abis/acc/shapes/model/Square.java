package be.abis.acc.shapes.model;

import java.awt.*;

public class Square extends Rectangle {

    public Square(double length, Color color, Point point) {
        super(length, length, color, point);
    }

    public double getLength() {
        return this.getWidth();
    }

}
