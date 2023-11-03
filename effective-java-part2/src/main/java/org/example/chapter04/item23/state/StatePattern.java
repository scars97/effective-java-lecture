package org.example.chapter04.item23.state;

// 객체의 상태 관리르 더 구조적으로 처리
public class StatePattern {

    public static void main(String[] args) {
        Figure figure = new Figure();

        figure.setState(new CircleState(2.5));
        System.out.println(figure.calculateArea());

        figure.setState(new RectangleState(4.0, 5.0));
        System.out.println(figure.calculateArea());
    }
}
