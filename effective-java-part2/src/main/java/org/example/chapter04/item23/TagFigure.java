package org.example.chapter04.item23;

public class TagFigure {

    enum Shape { RECTANGLE, CIRCLE, SQUARE };

    // 태그 필드 - 현재 모양을 나타낸다.
    final Shape shape;

    // 다음 필드들은 모양이 사각형(RECTANGLE)일 때만 쓰인다.
    double length;
    double width;

    // 다음 필드는 모양이 원(CIRCLE)일 때만 쓰인다.
    double radius;

    // 원용 생성자
    TagFigure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    TagFigure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }

    public static void main(String[] args) {
        TagFigure circle = new TagFigure(3);
        TagFigure rectangle = new TagFigure(3, 4);

        System.out.println(circle.area());
        System.out.println(rectangle.area());
    }

}
