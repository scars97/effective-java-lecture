package org.example.chapter04.item23.inheritance;

class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width  = width;
    }
    @Override
    double area() {
        return length * width;
    }
}
