package programmers.practice.wordTrans;

import java.util.Arrays;
//https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class Solution {

    public static void main(String[] args){
        String[] s={"hot", "dot", "dog", "lot", "log", "cog"};

        Solution sol = new Solution();
        System.out.println(sol.solution("hit", "cog", s));
    }

    public int solution(String begin, String target, String[] words) {
        int[] beginUnicode = begin.codePoints().toArray();
        int[] targetUnicode = target.codePoints().toArray();
        boolean hasWord = Arrays.asList(words).contains(target);

        if (!hasWord) return 0;

        int[][] wordsArray = Arrays.stream(words)
                .map(word -> word.codePoints().toArray())
                .toArray(int[][]::new);

        return DFS(wordsArray, beginUnicode, targetUnicode, 0);
    }

    int DFS(int[][] wordsArray, int[] temp, int[] target, int num) {
        if (Arrays.equals(temp, target)) return num;

        int best = Integer.MAX_VALUE;
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i][0] == -1) continue; // 이미 사용한 단어

            int same_num = 0; // 후보 단어마다 새로 카운트
            for (int j = 0; j < wordsArray[i].length; j++) {
                if (wordsArray[i][j] == temp[j]) same_num++;
            }

            if (same_num == temp.length - 1) {
                int[] savedWord = wordsArray[i].clone();
                wordsArray[i][0] = -1;                    // 방문 처리
                int result = DFS(wordsArray, savedWord, target, num + 1);
                wordsArray[i] = savedWord;                // 백트래킹: 원상 복구
                if (result < best) best = result;
            }
        }
        return best;
    }
}
