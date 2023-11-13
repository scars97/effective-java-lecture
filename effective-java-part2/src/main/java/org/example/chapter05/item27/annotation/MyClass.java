package org.example.chapter05.item27.annotation;

import java.util.Arrays;

@MyAnnotation
public class MyClass {

    public static void main(String[] args) {
        Arrays.stream(MyClass.class.getAnnotations()).forEach(System.out::println);
    }
}
