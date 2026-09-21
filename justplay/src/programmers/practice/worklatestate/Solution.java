package programmers.practice.worklatestate;
//https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=java
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args){
        int n=4;
        int[] works = {4, 3, 3};
        Solution sol = new Solution();
        System.out.println(sol.solution(n, works));
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        boolean min = Arrays.stream(works).sum()>0;
        if (!min) {
            return answer;
        }
        while(n>0) {
            int maxIndex = IntStream.range(0, works.length)
                    .boxed()
                    .max((i, j) -> Integer.compare(works[i], works[j]))
                    .orElse(-1);
            works[maxIndex] = works[maxIndex]-1;
            n=n-1;
        }
        answer = Arrays.stream(works).map(num->num*num).sum();
        return answer;
    }

}
