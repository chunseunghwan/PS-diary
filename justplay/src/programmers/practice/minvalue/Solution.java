package programmers.practice.minvalue;
//https://school.programmers.co.kr/learn/courses/30/lessons/12941
class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] A={1,4,2};
        int[] B={5,4,4};
        System.out.println(sol.solution(A, B));

    }

    public int solution(int[] A, int[] B){
        int answer =0;
        sort(A, false);
        sort(B, true);
        for (int i=0; i<B.length; i++){
            answer += B[i]*A[i];
        }
        return answer;
    }
    void sort(int[] A, boolean isReverse){
        for (int i=0; i<A.length-1; i++) {
            int minIDX = i;
            if (isReverse) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[minIDX] < A[j]) minIDX = j;
                }
            } else if (!isReverse) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[minIDX] > A[j]) minIDX = j;
                }
            }
            int temp = A[minIDX];
            A[minIDX] = A[i];
            A[i] = temp;
        }
    }
}
