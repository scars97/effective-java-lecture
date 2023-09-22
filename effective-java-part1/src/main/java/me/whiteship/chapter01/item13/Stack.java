package me.whiteship.chapter01.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    // 코드 13-2 가변 상태를 참조하는 클래스용 clone 메서드

    @Override public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            // TODO 1. 아래 코드 주석 시 stack, Object를 clone한 result 가 동일한 elements를 참조하게 됨
            // TODO 2. 서로 다른 인스턴스를 갖고 있지만 복제한 객체는 배열의 형태만 갖췄을 뿐 그 안의 인스턴스는 같은 값을 참조 -> 얕은 복제
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // clone이 동작하는 모습을 보려면 명령줄 인수를 몇 개 덧붙여서 호출해야 한다.
    public static void main(String[] args) {
        Object[] values = new Object[2];
        values[0] = "123-4567-8900";
        values[1] = "010-4289-7891";

        Stack stack = new Stack();
        for (Object arg : values)
            stack.push(arg);

        Stack copy = stack.clone();

        System.out.println("pop from stack");
        while (!stack.isEmpty())
            System.out.println(stack.pop() + " ");

        System.out.println("pop from copy");
        while (!copy.isEmpty())
            System.out.println(copy.pop() + " ");
    }
}
