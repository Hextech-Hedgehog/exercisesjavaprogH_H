package be.abis.acc.shapes.main;

import be.abis.acc.shapes.model.Circle;
import be.abis.acc.shapes.model.Rectangle;
import be.abis.acc.shapes.model.Square;
import be.abis.acc.shapes.model.Triangle;
import be.abis.acc.shapes.model.Line;
import java.awt.*;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        be.abis.acc.shapes.model.Shape[] shapes = {
                new Rectangle(20, 30, Color.ORANGE, new Point(20, 50)),
                new Circle(7.5, Color.BLUE, new Point()),
                new Square(50, Color.RED, new Point(150, 220)),
                new Line(23.0, Color.pink, new Point(500, 60)),
                new Triangle(17.0, 13.0, Color.CYAN, new Point(10, 300))
        };
        Arrays.stream(shapes).forEach(s -> System.out.println(s.getClass().getSimpleName() + " Area: " + s.area() + " Color: " + s.getColor()));
    }

}
