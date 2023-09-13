package me.whiteship.chapter01.item08.autoclosable;

import java.io.BufferedInputStream;
import java.io.IOException;

//AutoCloseable 인터페이스 하나만 구현하면 정리됨.
public class AutoClosableIsGood implements AutoCloseable{

    private BufferedInputStream inputStream;

    //정리할 작업
    @Override
    public void close() {
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("failed to close " + inputStream);
        }

    }
}
