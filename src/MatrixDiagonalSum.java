/** Problem No. 1572
 https://leetcode.com/problems/matrix-diagonal-sum/description/

 Example 1:
 Input: mat = [[1,2,3],
 [4,5,6],
 [7,8,9]]
 Output: 25
 Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 Notice that element mat[1][1] = 5 is counted only once.

 Example 2:
 Input: mat = [[1,1,1,1],
 [1,1,1,1],
 [1,1,1,1],
 [1,1,1,1]]
 Output: 8

 Example 3:
 Input: mat = [[5]]
 Output: 5
 */
public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(diagonalSum(mat));
    }

    /**
     Use while loop from i=0 to i < mat.length add value to sum for every mat[i][i] and set its value to 0 after
     adding to sum . Make another while loop for left side diagonal here sum = sum + mat[i][mat.length - 1 -i]
     */
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int i = 0;
        //Right Diagonal
        while(i < mat.length){
            sum = sum +  mat[i][i];
            mat[i][i++] = 0;  // here first set mat[i][i] = 0 then i++ as it is post increment
        }
        i = 0;
        //Left Diagonal
        while(i < mat.length){
            sum = sum + mat[i][mat.length - 1 - i++]; // here first set sum= sum + mat[i][mat.length - 1 - i]
            // and then i++ as it is post increment
        }
        return sum;
    }
}
