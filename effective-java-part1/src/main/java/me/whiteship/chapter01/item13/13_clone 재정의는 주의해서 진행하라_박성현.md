# 13. clone 재정의는 주의해서 진행하라.

---

- clone 규약
    - x.clone() != x → 반드시 true
      - 객체의 물리적인 동치성, 참조하는 레퍼런스가 달라야한다.
      - clone으로 만들어진 인스턴스는 생성자를 통해 만들어지지 않는다.
      - clone 메서드를 사용해서 만들어짐
    - x.clone().getClass() == x.getClass()  → 반드시 true
    - x.clone().equals(x) → true일 수도 아닐수도
- 불변 객체라면?
    - Clonenable 인터페이스를 구현하고
    - clone 메서드를 재정의한다. 이때 <u>super.clone()을 사용</u>해야 한다.

---

- 만약 super.clone()을 하지 않는다면
      
```java
public class Item implements Cloneable{
    private String name;
    
    @Override
    public Item clone() {
        // 오류 코드
        // 자기 자신을 리턴 
        Item item = new Item();
        item.name = this.name;
        return item;
        
        // 정상 작동 코드
        Item result = null;
        try {
            result = (Item) super.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
public class SubItem extends Item implements Cloneable {
    private String name;
    
    // 구체적인 타입은 상위 타입으로 변할 수 있지만
    // 상위 타입은 구체적 타입으로 변환되지 못함
    @Override
    public SubItem clone() {
        return (SubItem) super.clone();
    }

    public static void main(String[] args) {
        SubItem item = new SubItem();
        SubItem clone = item.clone();

        System.out.println(clone != null);
        System.out.println(clone.getClass() == item.getClass());
    }
}
```
---

- 상위 클래스를 상속받아 오버라이드할 때 접근지시자는 상위클래스의 접근지시자와 같거나 더 넓은 범위의 접근지시자여야함.
- 오버라이드하는 메서드의 리턴타입을 하위 클래스 타입으로 선언해도 된다.
  - 타입 캐스팅을 하지 않아도 되는 장점이 있음.


```java

```