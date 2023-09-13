package me.whiteship.chapter01.item08.cleaner;

import java.util.List;

public class BigObject {

    //정리해야하는 리소스
    private List<Object> resource;
    public BigObject(List<Object> resource) {
        this.resource = resource;
    }

    //finalize에서 하던 작업을 Runnalbe 의 구현체로 정의하여 작업
    //내가 정리하려는 object를 참조하면 절대 안됨
    //정리하려던, 없애려던 객체가 다시 생성될 수 있기 때문.
    public static class ResourceCleaner implements Runnable {
        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up");
        }
    }
}
