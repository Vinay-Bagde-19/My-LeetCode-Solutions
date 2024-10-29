/** Problem No. 1277 Medium
 https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

 Given a, m * n matrix of ones and zeros, return how many square submatrices have all ones.

 Example 1:
 Input: matrix =[[0,1,1,1],
                [1,1,1,1],
                [0,1,1,1]]
 Output: 15
 Explanation:
 Thquares of side 1.
 There are 4 squares of side 2.
 There is  1 squaere are 10 sre of side 3.
 Total number of squares = 10 + 4 + 1 = 15.

 Example 2:
 Input: matrix =[[1,0,1],
                [1,1,0],
                [1,1,0]]
 Output: 7
 Explanation:
 There are 6 squares of side 1.
 There is 1 square of side 2.
 Total number of squares = 6 + 1 = 7.
 */
public class CountSquareSubmatrices_withAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                        {0,1,1,1},
                        {1,1,1,1},
                        {0,1,1,1}
        };

        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        // copy the first row as it is.
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
        }

        // copy the first col as it is.
        for (int j = 0; j < row; j++) {
            dp[j][0] = matrix[j][0];
        }

        //store other values in dp if 1 in matrix set value at dp = 1 + minimum([i-1][j], [i][j-1], [i-1][j-1]).
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + (Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])));
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int sum = 0;
        //Find sum of all the values which will be the total no. of square submatrics
        for(int i = 0; i < row; i++){
            for(int j=0; j < col; j++){
                sum = sum + dp[i][j];
            }
        }

        return sum;
    }
}
