package programmers.practice.network;
//https://school.programmers.co.kr/learn/courses/30/lessons/43162

public class Solution{

    public static void main(String[] args){
        int[][] cpts ={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution sol = new Solution();
        System.out.println(sol.solution(3, cpts));
    }

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int networkCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, n);
                networkCount++;
            }
        }
        return networkCount;
    }

    void dfs(int[][] computers, int node, int n) {
        visited[node] = true;
        for (int j = 0; j < n; j++) {
            if (computers[node][j] == 1 && !visited[j]) {
                dfs(computers, j, n);
            }
        }
    }
}











