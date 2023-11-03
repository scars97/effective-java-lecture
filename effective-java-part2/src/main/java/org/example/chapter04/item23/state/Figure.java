package org.example.chapter04.item23.state;

// 컨텍스트 클래스
class Figure {

    private FigureState state;

    public void setState(FigureState state) {
        this.state = state;
    }

    public double calculateArea() {
        return state.area();
    }
}
