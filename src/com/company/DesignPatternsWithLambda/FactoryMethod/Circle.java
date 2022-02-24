package com.company.DesignPatternsWithLambda.FactoryMethod;

import java.awt.*;


public class Circle {
    private final Color color;

    public Circle(){
        this(Color.WHITE);
    }

    public Circle(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Circle [color " + color + "]";
    }
}
