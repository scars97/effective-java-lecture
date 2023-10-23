package org.example.chapter04.item20.mixin;

class UserManager extends LoggerMixinImpl{

    private String username;

    public UserManager(String username) {
        this.username = username;
    }

    public void login() {
        log("User " + username + " logged in");
    }
}
