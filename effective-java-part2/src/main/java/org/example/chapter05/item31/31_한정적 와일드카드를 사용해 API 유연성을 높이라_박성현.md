# 31. 한정적 와일드카드를 사용해 API 유연성을 높이라.

---

## PECS - Producer-Extends, Consumer-Super
- Get and Put Principle
- 와일드카드(?)를 사용할 때 생길 수 있는 혼란을 줄이기 위한 규칙
- 생산자(producer)라면 extends, 소비자(consumer)라면 super

### (1) Producer-Extends
- 데이터를 생산, 저장될 때에 extends 사용
  - `<? extends E>`

```java
// 와일드카드 타입을 사용하지 않은 pushAll 메서드
// 컴파일은 가능하지만 main 실행시 오류.
// Integer는 Number의 하위 타입이지만
// 제네릭 매개변수화 타입은 불공변이기 때문
public void pushAll(Iterable<E> src) {
   for (E e : src)
       push(e);
}

// E 생산자(producer) 매개변수에 와일드카드 타입 적용
// E의 하위타입의 Iterable -> Number의 하위타입(Integer)의 Iterable
public void pushAll(Iterable<? extends E> src) {
    for (E e : src)
        push(e);
}

public static void main(String[] args) {
    Stack<Number> numberStack = new Stack<>();
    // 데이터를 저장하는 생산자 객체
    Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
    numberStack.pushAll(integers);
    // ...
}
```

### (2) Consumer-Super
- 데이터를 조회할 때는 super 사용
  - `<? super E>`

```java
// 와일드카드 타입을 사용하지 않은 popAll 메서드
// Producer-Extends와 같은 오류 발생.
public void popAll(Collection<E> dst) {
    while (!isEmpty())
        dst.add(pop());
}

// E 소비자(consumer) 매개변수에 와일드카드 타입 적용
// E의 상위 타입의 Collection -> Number의 상위 타입(Object)의 Collection
public void popAll(Collection<? super E> dst) {
    while (!isEmpty())
        dst.add(pop());
}

public static void main(String[]args){
    // ...
        
    // 데이터를 조회하는, 꺼내오는 소비자 객체
    Collection<Object> objects = new ArrayList<>();
    numberStack.popAll(objects);
}
```

<blockquote>
유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라. <br>
한편, 입력 매개변수가 생산자와 소비자 역할을 동시에 한다면 와일드카드 타입을 사용하지 말아야 한다.
</blockquote>