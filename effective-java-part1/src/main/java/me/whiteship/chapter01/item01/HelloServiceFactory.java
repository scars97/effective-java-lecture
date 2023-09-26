package me.whiteship.chapter01.item01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HelloServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 현재 참조가능한 HelloService의 구현체를 모두 가져옴
//        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
//        Optional<HelloService> helloServiceOptional = loader.findFirst();
//        helloServiceOptional.ifPresent(h -> {
//            System.out.println(h.hello());
//        });
        Class<?> aClass = Class.forName("me.whiteship.chapter01.item01.KoreanHelloService");
        Constructor<?> constructor = aClass.getConstructor();
        HelloService helloService = (HelloService) constructor.newInstance();
        System.out.println(helloService.hello());
    }
}
