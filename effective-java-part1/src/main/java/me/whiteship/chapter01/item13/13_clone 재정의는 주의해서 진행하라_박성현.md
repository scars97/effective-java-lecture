# 13. clone 재정의는 주의해서 진행하라.

---

## -  clone 규약
- x.clone() != x → 반드시 true
  - 객체가 참조하는 레퍼런스가 달라야한다.
  - clone으로 만들어진 인스턴스는 생성자를 통해 만들어지지 않는다.
  - clone 메서드를 사용해서 만들어짐
- x.clone().getClass() == x.getClass()  → 반드시 true
- x.clone().equals(x) → true일 수도 아닐수도 

### 1. 불변 객체라면?
    - Clonenable 인터페이스를 구현하고
    - clone 메서드를 재정의한다. 이때 <u>super.clone()을 사용</u>해야 한다.
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

### 2. 가변 객체의 clone 구현 방법
- 접근 제한자는 public, 반환 타입은 자신의 클래스로 변경.
- super.clone()을 호출한 뒤 필요한 필드를 적절히 수정한다.
  - 배열을 복제할 때는 배열의 clone 메서드를 사용하라.
  - 경우에 따라 final을 사용할 수 없을 지도 모른다.
  - 필요한 경우 deep copy를 해야 한다.
  - super.clone()으로 객체를 만든 뒤, 고수준 메서드를 호출하는 방법도 있다.
  - 오버라이딩 할 수 있는 메서드는 참조하지 않도록 조심해야 한다.
  - 상속용 클래스는 Cloneable을 구현하지 않는 것이 좋다.
  - Cloneable을 구현한 스레드 안전 클래스를 작성할 때는 동기화를 해야 한다.
```java

```