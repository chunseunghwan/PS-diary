## 정수 삼각형 (Integer Triangle)

- 문제: [프로그래머스 - 정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)
- 접근: 삼각형의 각 위치에서 아래(또는 위) 두 갈래 중 더 큰 값을 선택하며 합산해나가는 DP

### 시도 1 - 재귀적으로 삼각형을 한 줄씩 줄여나가는 방식 (`toSmallTriangle`)

맨 아래 두 줄을 합쳐서 삼각형을 한 층 줄이고, 이걸 한 줄 남을 때까지 재귀로 반복하는 아이디어로 시작함.

**버그 1 - `ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5`**

```java
smalltriangle = new int[tri_maxlength-1][triangle[tri_maxlength].length-1];
```

`tri_maxlength`는 `triangle.length`라서 유효한 인덱스는 `0 ~ tri_maxlength-1`인데, `triangle[tri_maxlength]`로 한 칸 넘어간 인덱스에 접근해서 발생. `triangle[tri_maxlength-1]`로 고쳐야 했음.

**버그 2 - 한 단계 더 들어간 곳에서 `ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4`**

인덱스는 고쳤는데, 배열을 아래처럼 직사각형으로 할당한 게 문제였음:

```java
smalltriangle = new int[tri_maxlength-1][triangle[tri_maxlength-2].length];
```

모든 행의 길이가 똑같이 고정돼버려서, 다음 재귀 호출에서 각 행의 실제 `.length`가 왜곡되고, 그 결과 인덱스 계산이 어긋나 재귀 두 단계째에서 범위를 벗어남. 삼각형 모양 그대로 유지하려면 행마다 길이가 다른 **가변(jagged) 배열**로 할당해야 했음.

```java
smalltriangle = new int[tri_maxlength-1][];
for (int row = 0; row < tri_maxlength - 1; row++) {
    smalltriangle[row] = new int[triangle[row].length];
}
```

**버그 3 - 크래시는 안 나는데 결과가 30이 아니라 105로 나옴**

가변 배열로 고친 뒤 크래시는 사라졌지만 결과값이 이상하게 큼. 원인은 인덱스가 아니라 **알고리즘 자체**였음: 매 재귀마다 위에서 아래까지 "모든 인접한 행 쌍"을 전부 새로 합치고 있었는데, 이러면 중간 행들의 값이 재귀가 반복될수록 여러 번 중복으로 더해짐.

```java
// 잘못된 방식 - 모든 행을 한 번에 갱신
for (int row=0; row<tri_maxlength-1; row++){
    for (int col=0; col<triangle[row].length; col++){
        smalltriangle[row][col] = triangle[row][col] + Math.max(triangle[row+1][col], triangle[row+1][col+1]);
    }
}
```

**최종 수정 - 매 재귀마다 "맨 아래 두 줄만" 합치고, 위쪽 행들은 그대로 유지**

```java
int[][] toSmallTriangle(int[][] triangle){
    int tri_maxlength = triangle.length;
    smalltriangle = new int[tri_maxlength-1][];

    // 위쪽 행들은 그대로 복사
    for (int row = 0; row < tri_maxlength - 2; row++) {
        smalltriangle[row] = triangle[row];
    }

    // 마지막 두 행만 합쳐서 새로운 마지막 행을 만든다
    int last = tri_maxlength - 1;
    int secondLast = tri_maxlength - 2;
    smalltriangle[secondLast] = new int[triangle[secondLast].length];
    for (int col = 0; col < triangle[secondLast].length; col++){
        smalltriangle[secondLast][col] = triangle[secondLast][col]
                + Math.max(triangle[last][col], triangle[last][col+1]);
    }

    if (smalltriangle.length != 1) toSmallTriangle(smalltriangle);
    return smalltriangle;
}
```

`{{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}}` 입력에 대해 정답 **30**을 정확히 출력하는 것까지 확인함.

### 시도 2 - 위에서 아래로 채워나가는 top-down DP (`addMaxArray`) — 진행 중

재귀로 삼각형을 줄여나가는 대신, `addMaxArray[i][j]`에 "그 위치까지 올 수 있는 최대 누적합"을 기록하며 아래로 내려가는 방식으로 다시 시도함.

- 버그: 안쪽 for문의 증감식이 `j++`가 아니라 `i++`로 돼 있어서 `ArrayIndexOutOfBoundsException` 발생 → `j++`로 수정
- 버그: `max` 변수에 최댓값을 다 구해놓고 정작 `return answer;`의 `answer`에는 대입을 안 해서 항상 0을 반환 → `answer = max;` 필요
- (확인 필요) `addMaxArray`를 `n x n` 직사각형으로 잡아놔서, 맨 오른쪽 대각선 칸(`j == i`)에서 `bringUpperRight`가 존재하지 않는 위치인데도 기본값 0을 가져오는 부분 — 지금 입력에선 우연히 값에 영향을 안 주지만 다른 입력에서는 틀릴 수 있어 점검 필요