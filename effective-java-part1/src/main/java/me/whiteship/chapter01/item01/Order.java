package me.whiteship.chapter01.item01;

public class Order {

    private boolean prime;
    private boolean urgent;
    private Product product;

    // 1. 생성자의 시그니처가 중복되는 경우 고려
    // 2. 인스턴스는 새로 만들어질 필요는 없다
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }
}
