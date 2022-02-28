package com.company.DesignPatternsWithLambda.FactoryMethod;


import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Factory<T> extends Supplier<T> {

    static Factory<Circle> createCircle(){
        return Circle::new;
    }

    static Factory<Circle> createCircle(Color color){
        return () -> new Circle(color);
    }


    default T newInstance(){
         return get();
    }

//    method that creates 5 circles
    default List<T> getFiveCircles(){
        return IntStream.range(0,5)
                .mapToObj(fiveCircles -> newInstance())
                .collect(Collectors.toList());
    }

    default List<T> getFiveCircles(Color color){
        return IntStream.range(0,5)
                .mapToObj(fiveCircles -> newInstance())
                .collect(Collectors.toList());
    }







}
