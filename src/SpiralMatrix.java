import java.util.ArrayList;
import java.util.List;

/** Problem No. 54
 https://leetcode.com/problems/spiral-matrix/

 Given an m x n matrix, return all elements of the matrix in spiral order.
 Example 1:
 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [1,2,3,6,9,8,7,4,5]

 Example 2:
 Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        //Create a result list
        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = m-1;
        int bottom = n-1;

        //Move top -> right -> bottom -> left ->again top.....
        while(top <= bottom && left <= right){
            //Right
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //Bottom
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //Left
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //Top
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
