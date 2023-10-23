package org.example.chapter04.item20.mixin;

class LoggerMixinImpl implements LoggerMixin{

    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
