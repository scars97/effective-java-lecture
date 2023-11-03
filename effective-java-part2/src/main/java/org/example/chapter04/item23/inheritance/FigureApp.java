package org.example.chapter04.item23.inheritance;

public class FigureApp {

    public static void main(String[] args) {
        Figure circle = new Circle(3.14);
        Figure rectangle = new Rectangle(3, 4);

        System.out.println(circle.area());
        System.out.println(rectangle.area());
    }
}
