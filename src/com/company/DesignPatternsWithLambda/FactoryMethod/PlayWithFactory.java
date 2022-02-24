package com.company.DesignPatternsWithLambda.FactoryMethod;


import java.awt.*;
import java.util.List;

public class PlayWithFactory {
    public static void main(String[] args) {


      Factory<Circle> factory = Factory.createCircle();


      Circle circle = factory.newInstance();
      System.out.println("circle: " + circle);

      List<Circle> getCircles = factory.getFiveCircles();
      System.out.println(getCircles);


//      circles with color


        System.out.println("circles with color ");
        List<Circle> getCirclesWithColor = factory.getFiveCircles(Color.YELLOW);
        System.out.println(getCirclesWithColor);















    }
}
