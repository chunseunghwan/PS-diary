package programmers.practice.dpfloyd;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int INF = (int) 1e8;

    // next[i][j] : i에서 j로 갈 때 다음에 방문할 정점 (-1 이면 경로 없음)
    static int[][] next;

    static void floydWarshall(int[][] dist) {
        int V = dist.length;
        next = new int[V][V];

        // next 초기화
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j || dist[i][j] != INF) next[i][j] = j;
                else next[i][j] = -1;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];   // 경로 갱신
                    }
                }
            }
        }
    }

    // 음수 사이클 판별: 자기 자신까지의 거리가 음수면 음수 사이클 존재
    static boolean hasNegativeCycle(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            if (dist[i][i] < 0) return true;
        }
        return false;
    }

    // i -> j 경로 복원
    static List<Integer> getPath(int i, int j) {
        List<Integer> path = new ArrayList<>();
        if (next[i][j] == -1) return path;   // 경로 없음

        path.add(i);
        while (i != j) {
            i = next[i][j];
            path.add(i);
        }
        return path;
    }

    static void printResult(int[][] dist) {
        int V = dist.length;

        System.out.println("[최단 거리 행렬]");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + "\t");
            }
            System.out.println();
        }

        System.out.println("\n[모든 정점 쌍의 최단 경로]");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) continue;
                List<Integer> path = getPath(i, j);
                if (path.isEmpty()) {
                    System.out.println(i + " -> " + j + " : 경로 없음");
                } else {
                    System.out.println(i + " -> " + j + " (비용 " + dist[i][j] + ") : " + path);
                }
            }
        }
    }

    static void run(String title, int[][] dist) {
        System.out.println("========== " + title + " ==========");
        floydWarshall(dist);

        if (hasNegativeCycle(dist)) {
            System.out.println("음수 사이클이 존재하여 최단 거리를 정의할 수 없습니다.\n");
            return;
        }
        printResult(dist);
        System.out.println();
    }

    public static void main(String[] args) {
        // 1) 기존 예제 (양수 가중치)
        int[][] graph1 = {
                {0,   4,   INF, 5,   INF},
                {INF, 0,   1,   INF, 6},
                {2,   INF, 0,   3,   INF},
                {INF, INF, 1,   0,   2},
                {1,   INF, INF, 4,   0}
        };
        run("양수 가중치", graph1);

        // 2) 음수 간선은 있지만 음수 사이클은 없음 -> 정상 동작
        int[][] graph2 = {
                {0,   3,   INF, INF},
                {INF, 0,   -2,  INF},
                {INF, INF, 0,   4},
                {1,   INF, INF, 0}
        };
        run("음수 간선 (사이클 없음)", graph2);

        // 3) 음수 사이클 존재: 0 -> 1 -> 2 -> 0 의 합 = 1 + (-3) + 1 = -1
        int[][] graph3 = {
                {0,   1,   INF},
                {INF, 0,   -3},
                {1,   INF, 0}
        };
        run("음수 사이클", graph3);
    }
}