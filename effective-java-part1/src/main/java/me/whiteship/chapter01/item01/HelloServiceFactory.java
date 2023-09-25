package me.whiteship.chapter01.item01;

public class HelloServiceFactory {

    public static void main(String[] args) {
        HelloService eng = HelloService.of("eng");
        HelloService ko = HelloService.of("ko");

        System.out.println(eng.hello());
        System.out.println(ko.hello());
    }
}
