package org.example.chapter04.item20.mixin;

public class LoggerApp {

    public static void main(String[] args) {
        ProductService product = new ProductService("Product A");
        product.process();

        UserManager user = new UserManager("user123");
        user.login();
    }
}
