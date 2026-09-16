package programmers.practice.IsavailablebinaryTree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args){
        Solution sol = new Solution();
        long[] l = {7,42,5,63,111,95};

        Arrays.stream(sol.solution(l)).forEach(System.out :: println);
    }

    public int[] solution(long[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++ ){
            String binary = Long.toBinaryString(numbers[i]);
            int bianryLength = binary.length();

            // 포화트리 길이 구함
            int perfectLength = ((bianryLength & (bianryLength + 1)) == 0) ? bianryLength : Integer.highestOneBit(bianryLength) * 2 - 1;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < perfectLength - bianryLength; j++) sb.append('0');
            sb.append(binary);

            char[] tree = sb.toString().toCharArray();
            System.out.println("########################");
            System.out.println(tree);
            if(Iscanbinarytree(tree, 0, tree.length-1)) answer[i]=1;
        }


        return answer;
    }

    boolean Iscanbinarytree(char[] tree, int checkstart, int checkend){
        if (checkstart>=checkend) return true; //fix

        int root = (checkend+checkstart)/2;
        System.out.println("checkstart:"+checkstart);
        System.out.println("checkend:"+checkend);
        if (tree[root] == '0'){
            for(int i = checkstart ; i<=checkend; i++){
                if (tree[i] == '1') return false;
            }

            return true;
        }
        return Iscanbinarytree(tree, checkstart, root-1) && Iscanbinarytree(tree, root+1, checkend);
    }
}


