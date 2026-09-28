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
        long total_work = Arrays.stream(works).sum();
        if (total_work<=n) return 0;
        PriorityQueue<Integer> pri_queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : works) pri_queue.add(w);
        while(n>0){
            int max = pri_queue.poll();
            pri_queue.add(max-1);
            n--;
        }
        answer = pri_queue.stream().mapToLong(num->num*num).sum();

        return answer;
    }

}
