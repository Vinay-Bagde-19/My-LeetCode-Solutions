/** Problem No. 1351
 https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

 Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 return the number of negative numbers in grid.

 Example 1:
 Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 Output: 8
 Explanation: There are 8 negatives number in the matrix.

 Example 2:
 Input: grid = [[3,2],[1,0]]
 Output: 0
 */
public class CountNegativeNumbers_in_aSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };

        System.out.println(countNegatives(matrix));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0; i < row; i++){
            int start = 0;
            int end = col-1;
            int rowCount = 0;

            //Binary search in each row to find the first negative number
            while(start <= end){
                int mid = start + (end - start)/2;

                if(grid[i][mid] < 0){
                    rowCount = col - mid; //All remaining elements mid and after mid
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }
            count = count + rowCount;
        }
        return count;
    }
}
