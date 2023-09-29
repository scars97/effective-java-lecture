# 14. Comparable을 구현할지 고민하라.

---

## compareTo 규약
- Object.equals에 더해서 순서까지 비교할 수 있으며, 제네릭을 지원한다.
- 자기 자신이 compareTo에 전달된 객체보다 작으면 음수, 같으면 0, 크다면 양수를 리턴한다.
- 반사성, 대칭성, 추이성을 만족해야 한다.
- 반드시 따라야 하는 것은 아니지만 x.compareTo(y) == 0 이라면 x.equals(y)가 true여야 한다.