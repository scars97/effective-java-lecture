package org.example.chapter04.item23.strategy;

class Figure {

    private FigureStrategy strategy;

    public void setStrategy(FigureStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateArea() {
        return strategy.area();
    }
}