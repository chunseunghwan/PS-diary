package programmers.practice.integertriangle;

class Solution {

    int [][] smalltriangle;

    public static void main(String[] args){
        int[][] t = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution sol = new Solution();
        System.out.println(sol.solution(t));
    }

    public int solution(int[][] triangle) {
        int answer = 0;

        answer = toSmallTriangle(triangle)[0][0];
        return answer;
    }

    int[][] toSmallTriangle(int[][] triangle){

        int tri_maxlength = triangle.length; //5
        smalltriangle = new int[tri_maxlength-1][];
        for (int row = 0; row < tri_maxlength-1; row++)
            smalltriangle[row] = new int[triangle[row].length];
        for (int row=0; row<tri_maxlength-2; row++)
            smalltriangle[row] = triangle[row];
        for (int col=0; col<triangle[tri_maxlength-2].length; col++){
            smalltriangle[tri_maxlength-2][col] = triangle[tri_maxlength-2][col] + Math.max(triangle[tri_maxlength-1][col], triangle[tri_maxlength-1][col+1]);
        }
//        for (int row=0; row<tri_maxlength-1; row++){
//            for (int col=0; col<triangle[row].length; col++){
//                if (triangle[row+1][col]>=triangle[row+1][col+1]) smalltriangle[row][col]=triangle[row+1][col]+triangle[row][col];
//                else smalltriangle[row][col]=triangle[row+1][col+1]+triangle[row][col];
//            }
//        }
// "자기 행 + 바로 아래 행"의 값이 더해져 있는데, 다음 재귀 호출에서 또 같은 방식으로 (지금의 행) + (지금의 아래 행)을 더합니다. 즉 중간에 있던 행의 값이 재귀가 반복될수록 여러 번 중복으로 누적
        if (smalltriangle.length != 1) toSmallTriangle(smalltriangle);
        return smalltriangle;
    }
}

