# 코딩테스트 풀이 저장소

프로그래머스에서 푼 코딩테스트 문제들을 카테고리별 패키지로 정리한 저장소입니다.

## 기술 스택

- Java
- IntelliJ IDEA

## 폴더 구조

각 문제는 `카테고리.문제명` 형태의 패키지로 구성되어 있고, 폴더 안에는 정답 코드와 간단한 예제 검증 코드가 함께 들어 있습니다.

```
src/
├── practice/
│   ├── jadencase/
│   │   └── Solution.java
│   ├── minvalue/
│   │   └── Solution.java
│   └── maxmin/
│   │   └── Solution.java
│   └── validparentheses/
│   │   └── Solution.java
    └── binaryconversion/
        └── Solution.java
     ....
```

## 각 폴더 구성 규칙

- `Solution.java` : 프로그래머스에 제출한 정답 코드
- `main` 메서드 : 예제 입출력 몇 가지를 직접 돌려서 결과를 확인하는 최소한의 검증 코드

## 학습 기록

문제를 풀면서 겪은 실수나 배운 점은 각 문제 폴더의 README 또는 커밋 메시지에 간단히 남겨서, 나중에 비슷한 실수를 반복하지 않도록 합니다.

예시로 남기면 좋은 것들:
- 어떤 접근으로 풀었는지 (Brute force / 정렬 / 투 포인터 / 재귀 등)
- 처음에 틀렸던 이유와 고친 방법
