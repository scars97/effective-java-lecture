package org.example.chapter04.item23.strategy;

class CircleStrategy implements FigureStrategy{
    private final double radius;

    CircleStrategy(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
