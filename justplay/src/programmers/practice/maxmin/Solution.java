package programmers.practice.maxmin;

class Solution {

    public static void main(String[] args){

        Solution sol = new Solution();
        String s = "-4 1 2 3 4";
        System.out.println(sol.solution(s));
    }

    public String solution(String s) {
        String[] words = s.split("\\s+");
        int[] Array_charToNum = new int[words.length];
        for (int i=0; i<Array_charToNum.length; i++) {
            Array_charToNum[i]=Integer.parseInt(words[i]);
        }
        int min = Array_charToNum[0];
        int max = Array_charToNum[0];
        for (int i=0; i<Array_charToNum.length; i++){
            if (Array_charToNum[i] < min) min=Array_charToNum[i];
            if (Array_charToNum[i] > max) max=Array_charToNum[i];
        }
        String mins = Integer.toString(min);
        String maxs = Integer.toString(max);
        String answer = mins +" "+ maxs;
        return answer;
    }
}
