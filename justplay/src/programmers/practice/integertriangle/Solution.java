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

//        for (int i=0; i<tri_maxlength-1; i++){
//            if(triangle[tri_maxlength][i]>triangle[tri_maxlength][i+1])
//                smalltriangle[tri_maxlength-1][i] = triangle[tri_maxlength][i]+triangle[tri_maxlength-1][i];
//            else
//                smalltriangle[tri_maxlength-1][i] = triangle[tri_maxlength][i+1]+triangle[tri_maxlength-1][i];
//        }
        for (int row=0; row<tri_maxlength-1; row++){
            for (int col=0; col<triangle[row].length; col++){
                if (triangle[row+1][col]>=triangle[row+1][col+1]) smalltriangle[row][col]=triangle[row+1][col]+triangle[row][col];
                else smalltriangle[row][col]=triangle[row+1][col+1]+triangle[row][col];
            }
        }
        if (smalltriangle.length != 1) toSmallTriangle(smalltriangle);
        return smalltriangle;
    }
}

