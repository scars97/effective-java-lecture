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
- 해시충돌 문제.
- 두 객체가 같은 hashCode를 가진 버킷에 들어가는데 그 안에 LinkedList가 만들어짐.
- hashMap은 배열의 인덱스처럼 바로 꺼내는 것이 가능하지만
- LinkedList는 배열의 첫순서부터 값을 비교하여 저장하거나 값을 가져오기 때문에 
- 비용증가, 성능저하, 알고리즘 효율성 ↓

---

## 2. hashCode 구현

