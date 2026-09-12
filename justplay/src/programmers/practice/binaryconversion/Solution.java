package programmers.practice.binaryconversion;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "1101011";
        System.out.println(sol.solution(s)[0]);
        System.out.println(sol.solution(s)[1]);

    }


    public int[] solution(String s) {
        int[] answer = new int[2];
        String[] str = s.split("");
        int[] stringtoBinArry = new int[str.length];
        for (int i=0; i<str.length; i++){
            if (str[i].equals("1")) stringtoBinArry[i] = 1;
            else if (str[i].equals("0")) {
                stringtoBinArry[i]=0;
            }
        }
        foundf(stringtoBinArry, answer);
        return answer;
    }

    private int[] foundf(int[] ary, int[] answer){
        int count_1 = 0;
        int count_0 = 0;
        answer[0] = answer[0]+1;
        for (int i=0; i<ary.length; i++){
            if (ary[i]==1) count_1 += 1;
            else answer[1]+=1;
        }
        int[] temp = new int[count_1];
        for (int i=0; i<count_1; i++){
            temp[i]=1;
        }
        if (temp.length!=1) {
            String s = Integer.toBinaryString(temp.length);
            String[] str =s.split("");
            int[] deepin = new int[str.length];
            for (int i=0; i<str.length; i++){
                if (str[i].equals("1")) deepin[i] = 1;
                else if (str[i].equals("0")) {
                    deepin[i]=0;
                }
            }
            foundf(deepin, answer);
        }
        return answer;
    }
}