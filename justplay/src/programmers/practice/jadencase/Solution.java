package programmers.practice.jadencase;
//https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "3people unFollowed me";
        System.out.println(sol.solution(s));
    }

    public String solution(String s) {
        // 전체 문자열을 소문자로 변환하여 기본 상태로 만듦
        StringBuilder sb = new StringBuilder(s.toLowerCase());

        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);

            if (c == ' ') {
                isFirst = true;
            } else if (isFirst) {
                sb.setCharAt(i, Character.toUpperCase(c));
                isFirst = false;
            }
        }

        return sb.toString();
    }
}
