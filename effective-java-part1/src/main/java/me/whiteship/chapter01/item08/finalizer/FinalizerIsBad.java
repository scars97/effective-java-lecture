package me.whiteship.chapter01.item08.finalizer;

public class FinalizerIsBad {

    //Object에 정의되어 있는 메서드.
    //but finalize 보다 PhantomReference, cleaner 사용을 권장하고
    //지금은 AutoCloseable 과 try-with-resource 를 사용할 것
    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}
