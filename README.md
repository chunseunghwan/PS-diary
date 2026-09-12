# 코딩테스트 풀이 저장소

프로그래머스에서 푼 코딩테스트 문제들을 카테고리별 패키지로 정리한 저장소입니다.

## 기술 스택

- Java 17
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
│       └── Solution.java
├── stackqueue/
│   └── validparentheses/
│       └── Solution.java
└── monthlychallenge/
    └── binaryconversion/
        └── Solution.java
```

## 문제 목록

| 문제 | 카테고리 | 난이도 | 패키지 | 링크 |
|---|---|---|---|---|
| 이진 변환 반복하기 | 월간 코드 챌린지 시즌1 | Lv.2 | `monthlychallenge.binaryconversion` | [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/70129) |
| JadenCase 문자열 만들기 | 연습문제 | Lv.2 | `practice.jadencase` | [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12951) |
| 최솟값 만들기 | 연습문제 | Lv.2 | `practice.minvalue` | [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12941) |
| 최댓값과 최솟값 | 연습문제 | Lv.1 | `practice.maxmin` | [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12939) |
| 올바른 괄호 | 스택/큐 | Lv.2 | `stackqueue.validparentheses` | [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12909) |

## 각 폴더 구성 규칙

- `Solution.java` : 프로그래머스에 제출한 정답 코드
- `main` 메서드 : 예제 입출력 몇 가지를 직접 돌려서 결과를 확인하는 최소한의 검증 코드
- 필요시 `README.md` : 문제 조건, 접근 방법, 막혔던 부분 등을 간단히 기록

## 학습 기록

문제를 풀면서 겪은 실수나 배운 점은 각 문제 폴더의 README 또는 커밋 메시지에 간단히 남겨서, 나중에 비슷한 실수를 반복하지 않도록 합니다.

예시로 남기면 좋은 것들:
- 어떤 접근으로 풀었는지 (Brute force / 정렬 / 투 포인터 / 재귀 등)
- 처음에 틀렸던 이유와 고친 방법
- 시간복잡도/공간복잡도
