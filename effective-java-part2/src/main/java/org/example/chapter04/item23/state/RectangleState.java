package org.example.chapter04.item23.state;

class RectangleState implements FigureState{

    private double length;
    private double width;

    public RectangleState(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
