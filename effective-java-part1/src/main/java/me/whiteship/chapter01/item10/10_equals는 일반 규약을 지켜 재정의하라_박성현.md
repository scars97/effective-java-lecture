# 10. equals는 일반 규약을 지켜 재정의하라.

###
### 1. equals를 재정의 하지 않는 것이 최선
#### 1-1. equals를 재정의하지 않아도 될 경우
- 각 인스턴스가 본질적으로 고유할 때
  - 싱글톤
  - Enum
- <u>'논리적인 동치성'을 검사할 필요가 없는 경우</u>
  - 논리적 동치성 비교(equals)
    - 동일한 객체는 아니지만 객체의 상태 값이 서로 같은 경우를 논리적으로 동등하다 함.
- 상위 클래스에 정의한 equals를 하위클래스에 재사용할 때
- 클래스가 private이거나 package-private일 때 equals를 호출할 필요가 없다.
  - public일 경우 어디서든 참조가 가능하기 때문에 equals가 호출되지 않을 것이란 보장이 없음. 
  - List나 Map에, 구현한 public 클래스를 넣는다면 equals가 호출됨.


###
### 2. equals 규약
- 반사성: A.eqauls(A) == true
- 대칭성: A.eqauls(B) == B.eqauls(A)
```java
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위배!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // 한 방향으로만 작동한다!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    // 문제 시연 (55쪽)
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String polish = "polish";
        System.out.println(cis.equals(polish)); // true
        System.out.println(polish.equals(cis)); // false
        // CaseInsensitiveString에서 정의한 equals는
        // String을 알고 있지만
        // String 클래스는 CaseInsensitiveString의 존재를 알지 못함.
      
        // equals 규약을 어기면 그 객체를 사용하는
        // 다른 객체들이 어떻게 반응할지 알 수 없다.

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(polish)); // false
    }
    
    // 수정한 equals 메서드 (56쪽)
    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
```
- 추이성
  - A.eqauls(B) && B.eqauls(C), A.eqauls(C)
  - 구체 클래스를 확장해 새로운 값(필드)을 추가하면 equals 규약을 만족 시킬 수 없다.  
```java
public class Point {
    private final int x;
    private final int y;
    
    // ...
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    // 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
    @Override public boolean equals(Object o) {
      if (o == null || o.getClass() != getClass())
        return false;
      Point p = (Point) o;
      return p.x == x && p.y == y;
    }
}

public class ColorPoint extends Point { 
    private final Color color;
    
    // ...

    // 대칭성 위배
    @Override public boolean equals(Object o) {
      if (!(o instanceof ColorPoint))
        return false;
      
      // ColorPoint는 Point 타입이지만
      // Point는 ColorPoint 타입이 아니다.
      return super.equals(o) && ((ColorPoint) o).color == color;
    }

    // 추이성 위배
    @Override 
    public boolean equals(Object o) {
      if (!(o instanceof Point))
          return false;

      // o가 일반 Point면 색상을 무시하고 비교한다.
      // ColorPoint 레벨의 다른 클래스에 같은 방식으로 equals를 구현했다면
      // equals 메서드를 계속 호출하기 때문에 StackOverflow가 발생.
      if (!(o instanceof ColorPoint))
          return o.equals(this);

      // o가 ColorPoint면 색상까지 비교한다.
      return super.equals(o) && ((ColorPoint) o).color == color;
    }
}

public class CounterPoint extends Point {
    // 필드를 추가하지 않았으므로 상위 클래스의 equals를 사용해도 됨.
    // 상위 클래스에 정의한 equals를 하위클래스에 재사용할 때
    // equals를 재정의하지 않아도 된다고 했음.
    // ...
}

public class CounterPointTest {
    private static final Set<Point> unitCircle = Set.of(
          new Point( 1,  0), new Point( 0,  1),
          new Point(-1,  0), new Point( 0, -1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,  0);
        Point p2 = new CounterPoint(1,  0);
    
        // true
        System.out.println(onUnitCircle(p1));
    
        // true를 출력해야 하지만, 
        // 리스코프 치환 원칙으로 상위 클래스로 동작하고 있는 코드에 하위 클래스의 인스턴스가 들어가도 동일하게 동작해야 함.
        // but, Point의 equals가 getClass를 사용해 작성되었다면 그렇지 않다.
        // CounterPoint는 Point를 상속받고 있지만 
        // getClass를 사용하여 비교한다면 구체적 클래스를 비교하므로 false
        System.out.println(onUnitCircle(p2));
    }
}
```