package org.example.chapter04.item20.mixin;

class ProductService extends LoggerMixinImpl{

    private String name;

    public ProductService(String name) {
        this.name = name;
    }

    public void process() {
        log("Processing " + name);
    }
}
