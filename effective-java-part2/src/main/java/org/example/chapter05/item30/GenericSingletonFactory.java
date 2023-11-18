package org.example.chapter05.item30;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class GenericSingletonFactory {
    /*public static Function<String, String> stringIndentityFunction() {
        return (t) -> t;
    }
    public static Function<Number, Number> integerIndentityFunction() {
        return (t) -> t;
    }

    public static void main(String[] args) {
        String[] strings = { "삼베", "대마", "나일론" };
        Function<String, String> sameString = stringIndentityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        Function<Number, Number> sameNumber = integerIndentityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }*/

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    // 제네릭 싱글턴 팩토리
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = { "삼베", "대마", "나일론" };
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}
