package org.example.chapter04.item23.state;

class CircleState implements FigureState {

    private double radius;

    public CircleState(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
