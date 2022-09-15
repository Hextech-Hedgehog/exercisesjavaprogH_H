package be.abis.acc.shapes.model;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Shape {

    Color color;
    Point origin;
    Map<Color, String> colorNames = new HashMap<>(){{
        put(Color.BLACK, "black");
        put(Color.BLUE, "blue");
        put(Color.CYAN, "cyan");
        put(Color.DARK_GRAY, "dark gray");
        put(Color.GRAY, "gray");
        put(Color.GREEN, "green");
        put(Color.LIGHT_GRAY, "light gray");
        put(Color.MAGENTA, "magenta");
        put(Color.ORANGE, "orange");
        put(Color.PINK, "pink");
        put(Color.RED, "red");
        put(Color.WHITE, "white");
        put(Color.YELLOW, "yellow");
    }};

    public Shape(Color color, Point point) {
        this.color = color;
        this.origin = point;
    }

    public abstract double area();

    public String getColor() {
        String color = colorNames.get(this.color);
        return color == null ? this.getColor() : color;
    }

}
