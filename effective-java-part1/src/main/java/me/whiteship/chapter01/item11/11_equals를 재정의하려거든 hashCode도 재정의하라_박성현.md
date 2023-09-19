# 11. equals를 재정의하려거든 hashCode도 재정의하라.

---

## 1. hashCode 규약
- equals 비교에 사용하는 정보가 변경되지 않았다면 hashCode는 매번 같은 값을 리턴해야 한다.
  - 변경되거나, 애플리케이션을 다시 실행했다면 달라질 수 있다.
- 두 객체에 대한 equals가 같다면, hashCode의 값도 같아야 한다.
- 두 객체에 대한 equals가 다르더라고, hashCode의 값은 같을 수 있지만 해시 테이블 성능을 고려해 다른 값을 리턴하는 것이 좋다.

### 1-1. hashMap
- map에 값을 넣을 때도 hashCode() 실행
- 어느 버킷에 넣을 지 정함.
- 꺼낼 때도 hashCode 값을 먼저 가져와서
- 가져온 값의 hash에 해당하는 버킷 안의 object 가져옴.
- 결국엔 equals가 같다면 같은 hash값이 나와야함

### 1-2. 두 객체가 다르더라도, equals가 다르더라도 hashCode의 값이 같다면.
- `해시충돌` 문제.
- 두 객체가 같은 hashCode를 가진 버킷에 들어가는데 그 안에 연결리스트(해시맵 내부)가 만들어짐.
- 맨처음과 맨끝에 넣을 때는 O(1)
- 데이터를 조회할 때는 O(n) -> n은 충돌하는 엔트리의 개수
- hashMap은 배열의 인덱스처럼 바로 꺼내는 것이 가능하지만
- LinkedList는 모든 연결리스트의 값을 비교하여 값을 가져오기 때문에 
- 비용증가, 성능저하, 알고리즘 효율성 ↓

---

## 2. hashCode 구현
- 핵심 필드 하나의 값의 해쉬값을 계산해서 result 값을 초기화
  - 기본 타입은 Type(Wrapper).hashCode
  - 참조 타입은 해당 필드의 hashCode
  - 배열은 핵심 원소 각각을 별도 필드처럼 다룬다.
    - 모든 원소가 핵심 원소라면 Arrays.hashCode를 사용
```java
    // 전형적인 hashCode 메서드
    @Override 
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
```
-  해시 충돌이 적은 방법을 써야 한다면 '구아바'를 사용

```java
// 한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다.
// 입력 인수를 담기 위한 배열 생성
// 인수 중 기본 타입이 있다면 박싱, 언박싱을 거치기 때문
    @Override 
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }
```
- 클래스가 불변이고 해시코드를 계산하는 비용이 크다면, 필드에 해시코드 값을 캐싱
- 인스턴스가 만들어질 때 해시코드 계산
  - hashCode가 처음 불릴 때 계산하는 지연 초기화(lazy initialization) 전략
  - 지연 초기화하려면 클래스를 `스레드 안전`하게 만들어야 함
  - 하나의 스레드만 들어오는 것이 아닌 여러 스레드가 동시에 들어와 해쉬코드가 다르게 나올 수 있음
```java
    // 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다. (71쪽)
    private int hashCode; // 자동으로 0으로 초기화된다.

    @Override 
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
```
- 핵심필드(equals에 사용되는 필드)를 생략해선 안 된다.
- hashCode를 정의한 로직을 노출할 필요 없다. 
  - 노출하지 않아야
  - 클라이언트가 정의된 해시코드 값에 의지하지 않게 되고
  - 추후에 계산 방식을 바꿀 수 있음.

---

## 완벽 공략
### 1. 해시맵 내부의 연결 리스트
- 자바 8에서 해시 충돌시 성능 개선을 위해 내부적으로 동일한 버킷에
- 일정 개수 이상의 엔트리가 추가되면, 연결 리스트 대신 이진 트리를 사용


---
## 핵심정리
```
equals를 재정의할 때는 hashCode도 반드시 재정의.
그렇지 않으면 프로그램이 제대로 동작하지 않을 것.
재정의한 hashCode는 Object Api 문서에 기술된 일반 규약을 따라야 하며,
서로 다른 인스턴스라면 되도록 해시코드도 서로 다르게 구현해야 한다.
재정의한 코드는 우리가 만든 코드이기 때문에 잘 동작하는지 별도의 테스트가 필요함.
AutoValue와 Lombok을 사용한다면 검증된(?) equals와 hashCode를 만들어 줌.
```