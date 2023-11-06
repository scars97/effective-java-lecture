package org.example.chapter04.item24.memberclass;

public class OutterClass {

    private int number = 10;

    void printNumber() {
        InnerClass ex = new InnerClass();
    }

    private class InnerClass {
        void doSomething() {
            System.out.println(number);
            OutterClass.this.printNumber();
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OutterClass().new InnerClass();
        innerClass.doSomething();
    }
}
