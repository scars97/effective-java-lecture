# 4. 인스턴스화를 막으려거든 private 생성자를 사용하라.

---

### (1) 정적 메서드와 정적 필드만을 담은 클래스는 어떤 것이 있을까
- 기본 타입 값이나 배열 관련 메서드들을 모아놓은 `Math, Arrays` 
- 특정 인터페이스를 구현하는 객체를 생성해주는 정적 메서드들을 모아놓은 `Collections`
- final 클래스와 관련한 메서드들도 모아놓을 수 있다.
```java
public final class Math {
    /**
     * Don't let anyone instantiate this class. -> 인스턴스화 방지 주석
     */
    private Math() {
    }

    public static final double E = 2.7182818284590452354;

    public static double random() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
    }
    
    // Math 정적 내부 클래스
    private static final class RandomNumberGeneratorHolder {
      static final Random randomNumberGenerator = new Random();
    }
}
```
```java
public class Arrays {
    // Suppresses default constructor, ensuring non-instantiability.
    // 해석 : 기본 생성자를 억제하여 인스턴스화 불가능성을 보장합니다.
    private Arrays() {
    }

    public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);
    }

    // Arrays 정적 내부 클래스
    static final class LegacyMergeSort { ... }
}
```
```java
public class Collections {
    // Suppresses default constructor, ensuring non-instantiability.
    // 해석 : 기본 생성자를 억제하여 인스턴스화 불가능성을 보장합니다.
    private Collections() {
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
      list.sort(null);
    }
    
    // Collections 정적 내부 클래스
    static final class UnmodifiableEntrySetSpliterator<K, V>
            implements Spliterator<Entry<K,V>> { ... }
}

```

---

### (2) 인스턴스화를 막는 방법
- 정적 메서드만 담은 유틸리티 클래스는 인스턴스로 만들어 쓰려고 설계한 클래스가 아니다.
  - DateUtil, ServletRequestUtils ...
- 추상 클래스로 만드는 것으로는 인스턴스화를 막을 수 없다.
  - 추상 클래스를 상속한 클래스에서 인스턴스 생성 가능하기 때문.
- private 생성자를 추가하면 클래스의 인스턴스화를 막을 수 있다.
  - 클래스 안에서 인스턴스화되는 것을 막기 위해 AssertionError를 던질 수도 있다. 
  - 생성자에 주석으로 인스턴스화 불가한 이유를 설명하는 것이 좋다. 
  - 상속을 방지할 때도 같은 방법을 사용할 수 있다.
```java
public class UtilityClass() {
    /**
     * 기본 생성자가 만들어지는 것을 막는다 (인스턴화 방지용) 
     */
    private UtilityClass() {
          throw new AssertionError();
    }
    
    // ...
}
```
