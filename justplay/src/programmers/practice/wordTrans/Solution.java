package programmers.practice.wordTrans;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args){
        String[] s={"hot", "dot", "dog", "lot", "log", "cog"};

        Solution sol = new Solution();
        sol.solution("d", "b", s);
    }



    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] beginUnicode = begin.codePoints().toArray();
        int[] targetUnicode = target.codePoints().toArray();
        boolean hasWord = Arrays.asList(words).contains(target);

        if (!hasWord) return 0;

        int[][] StringToUnicode = Arrays.stream(words)
                .map(word -> word.codePoints().toArray())
                .toArray(int[][]::new);

        return answer;
    }
}
