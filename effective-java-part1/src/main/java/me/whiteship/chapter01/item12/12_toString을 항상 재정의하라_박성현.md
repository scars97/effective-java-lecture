# 12. toString을 항상 재정의하라.

---

- toString은 간결하면서 사람이 읽기 쉬운 형태의 유익한 정보를 반환해야 함.
- Object의 toString은 '클래스 이름@16진수로 표시한 해시코드'
- 객체가 가진 모든 정보를 보여주는 것이 좋다?
  - 주문내역을 가진 객체가 있다면 보여주는게 맞아..?
- 값 클래스라면 포맷을 문서에 명시하는 것이 좋으며 해당 포맷으로 객체를 생성할 수 있는 정적 팩터리나 생성자를 제공하는 것이 좋다.
```java
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // 정적 팩터리 메서드
    public static PhoneNumber of(String phoneNumberString) {
        String[] split = phoneNumberString.split("-");
        PhoneNumber phoneNumber = new PhoneNumber(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]));
        return phoneNumber;
    }

    public static void main(String[] args) {
        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
        System.out.println("제니의 번호: " + jenny);

        PhoneNumber phoneNumber = PhoneNumber.of("707-867-5309");
        System.out.println(phoneNumber);

      System.out.println(jenny.equals(phoneNumber)); // true
      System.out.println(jenny.hashCode(phoneNumber)); // true
    }
}
```
- toString이 반환한 값에 포함된 정보를 얻어올 수 있는 API를 제공하는 것이 좋다.
  - toString에 사용되는 데이터의 Getter 제공.
- 경우에 따라 AutoValue, Lombok, IDE를 사용하지 않는 것이 적절할 수도 있다.
  - 사용하는 객체의 특성에 맞게 toString을 제공해야하는 경우가 있으므로 직접 재정의하는 것이 좋음.

