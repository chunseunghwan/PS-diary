package programmers.practice.fibonacci;

public class Solution {

    static void main(String args[]) {
        Solution s = new Solution();
        int count = 50;
        for(int i=0; i<count; i++ ){System.out.println(s.solution(1,count)[i]);}
    }

    /**배열을 할당하고 초기 수를 저장*/
    public long[] solution(int s,int count){
        long[] answer = new long[count];
        answer[0] = 0;
        answer[1] = s;
        answer[2] = s+0;
        int index = 3;
        fibonacci(3, count, answer);
        return answer;
    }

    /**피보나치 수열을 연산하는 함수*/
    long[] fibonacci(int index,int count, long[] answer){
        if (index == count){return answer;}
        else if (index < count) {
            answer[index]=answer[index-2]+answer[index-1];
            index++;
            fibonacci(index,count,answer);
        }

        return answer;
    }
 }
