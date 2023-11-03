package org.example.chapter04.item23.strategy;

class StrategyPattern {

    public static void main(String[] args) {
        Figure figure = new Figure();

        figure.setStrategy(new CircleStrategy(2.0));
        System.out.println(figure.calculateArea());

        figure.setStrategy(new RectangleStrategy(3.0, 4.0));
        System.out.println(figure.calculateArea());
    }
}
