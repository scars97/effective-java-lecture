package me.whiteship.chapter01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) {
        // 현재 참조가능한 HelloService의 구현체를 모두 가져옴
//        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
//        Optional<HelloService> helloServiceOptional = loader.findFirst();
//        helloServiceOptional.ifPresent(h -> {
//            System.out.println(h.hello());
//        });
    }
}
