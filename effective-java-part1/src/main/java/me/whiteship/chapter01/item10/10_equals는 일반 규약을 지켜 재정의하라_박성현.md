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