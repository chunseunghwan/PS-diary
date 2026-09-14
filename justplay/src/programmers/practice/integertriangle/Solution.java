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
        int n = triangle.length;
        int[][] addMaxArray = new int[n][n];


        for (int i=0; i<n ; i++){
            for(int j=0; j<triangle[i].length; j++){
                if (i==0 && j==0) {
                    addMaxArray[i][j] = triangle[i][j];
                    continue;
                }

                int bringUpperLeft = (j != 0) ? addMaxArray[i-1][j-1] : 0;
                int bringUpperRight = addMaxArray[i-1][j];

                addMaxArray[i][j] = triangle[i][j] + Math.max(bringUpperLeft, bringUpperRight);
            }
        }
        int max = 0;
        for (int i : addMaxArray[n-1]){
            max = Math.max(i, max);
        }

        answer = max;
        //answer = toSmallTriangle(triangle)[0][0];
        return answer;
    }

//    int[][] toSmallTriangle(int[][] triangle){
//
//        int tri_maxlength = triangle.length;
//        smalltriangle = new int[tri_maxlength-1][];
//        for (int row = 0; row < tri_maxlength-1; row++)
//            smalltriangle[row] = new int[triangle[row].length];
//        for (int row=0; row<tri_maxlength-2; row++)
//            smalltriangle[row] = triangle[row];
//        for (int col=0; col<triangle[tri_maxlength-2].length; col++){
//            smalltriangle[tri_maxlength-2][col] = triangle[tri_maxlength-2][col] + Math.max(triangle[tri_maxlength-1][col], triangle[tri_maxlength-1][col+1]);
//        }
//        if (smalltriangle.length != 1) toSmallTriangle(smalltriangle);
//        return smalltriangle;
//    }
}

