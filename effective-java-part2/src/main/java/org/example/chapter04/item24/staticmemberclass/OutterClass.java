package org.example.chapter04.item24.staticmemberclass;

public class OutterClass {

    static class InnerClass {
        private int number = 10;

        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }
}
