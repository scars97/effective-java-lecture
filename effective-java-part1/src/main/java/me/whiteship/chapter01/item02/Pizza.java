package me.whiteship.chapter01.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // this로 pizza의 builder,즉 자기 자신을 리턴한다면
        //하위 클래스의 타입으로 빌더를 만들 때 타입캐스팅이 필요
        // but, 하위 클래스에서 재정의할 수 있는 추상화 메서드를 만들고
        // 그 메서드를 리턴해준다면 타입캐스팅 할 필요 없음
        public Builder<T> addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return this;
        }

        abstract Pizza build();

        //하위 클래스에서 형변환하지 않고도 메서드 연쇄를 지원
        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
}
