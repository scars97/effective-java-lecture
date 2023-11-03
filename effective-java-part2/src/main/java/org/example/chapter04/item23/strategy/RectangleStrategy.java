package org.example.chapter04.item23.strategy;

class RectangleStrategy implements FigureStrategy{
    private final double length;
    private final double width;

    RectangleStrategy(double length, double width) {
        this.length = length;
        this.width  = width;
    }
    @Override
    public double area() {
        return length * width;
    }
}
