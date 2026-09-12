package programmers.practice.validparentheses;
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "()()";
        System.out.println(sol.solution(s));
    }

    boolean solution(String s){
        boolean answer = true;
        int[] Gualho = new int[s.length()];
        int i=0;
        int sum=0;
        for (int cp : s.codePoints().toArray()){
            if (cp==40) sum++;
            if (cp==41) sum--;
            if (sum<0) return false;
            if (i==s.length()-1 && cp==40) return false;
            if (i==s.length()-1 && sum!=0) return false;
            i++;
        }

        return answer;
    }
}
