# 14. Comparable을 구현할지 고민하라.

---

## Comparable 규약
- Object.equals에 더해서 순서까지 비교할 수 있으며, 제네릭을 지원한다.
- 자기 자신이 compareTo에 전달된 객체보다 작으면 음수, 같으면 0, 크다면 양수를 리턴한다.
  - 비교할 수 없는 타입의 객체가 주어지면 ClassCastException을 던진다.
- 반사성, 대칭성, 추이성을 만족해야 한다.
- 반드시 따라야 하는 것은 아니지만 x.compareTo(y) == 0 이라면 x.equals(y)가 true여야 한다.
```java
public class CompareToConvention {
    public static void main(String[] args) {
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(53534552);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // 반사성
        System.out.println(n1.compareTo(n1)); // 0

        // 대칭성
        System.out.println(n1.compareTo(n2)); // 1
        System.out.println(n2.compareTo(n1)); // -1

        // 추이성
        System.out.println(n3.compareTo(n1) > 0); // true
        System.out.println(n1.compareTo(n2) > 0); // true
        System.out.println(n3.compareTo(n2) > 0); // true

        // compareTo가 0이라면 equals는 true여야 한다. (아닐 수도 있도)
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.compareTo(oneZeroZero)); // Tree, TreeMap
        System.out.println(oneZero.equals(oneZeroZero)); // 순서가 없는 콜렉션
    }
}
```

## Comparable 구현 방법 1
- 자연적인 순서를 제공할 클래스에 'implement Comparable<T>' 을 선언한다.
- compareTo 메서드를 재정의한다.
- compareTo 메서들 안에서 기본 타입은 박싱된 기본 타입의 compare을 사용해 비교한다.
```java
public class Point implements Comparable<Point> {

    final int x, y;
    
    // ...

    @Override
    public int compareTo(Point point) {
        int result = Integer.compare(this.x, point.x);
        if (result == 0) {
            result = Integer.compare(this.y, point.y);
        }
        return result;
    }
}
```
- 핵심 필드가 여러 개라면 비교 순서가 중요한다. 순서를 결정하는데 있어서 가장 중요한 필드를 비교하고 그 값이 0이라면 다음 필드를 비교한다.
```java
@Override
public int compareTo(PhoneNumber pn) {
    int result = Short.compare(areaCode, pn.areaCode);
    if (result == 0)  {
        result = Short.compare(prefix, pn.prefix);
        if (result == 0)
            result = Short.compare(lineNum, pn.lineNum);
    }
    return result;
}
```
- 기존 클래스를 확장하고 필드를 추가하는 경우 compareTo 규약을 지킬 방법이 없다.
  - Composition을 활용할 것.

## Comparable 구현 방법 2
- Comparable가 제공하는 static 메서드를 사용해서 Comparable 인스턴스 생성
- 