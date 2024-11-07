import java.util.Arrays;

/** Problem No. 977
 https://leetcode.com/problems/squares-of-a-sorted-array/

 Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
 in non-decreasing order.

 Example 1:
 Input: nums = [-4,-1,0,3,10]
 Output: [0,1,9,16,100]
 Explanation: After squaring, the array becomes [16,1,0,9,100].
 After sorting, it becomes [0,1,9,16,100].

 Example 2:
 Input: nums = [-7,-3,2,3,11]
 Output: [4,9,9,49,121]
 */
public class Squares_of_a_SortedArray {
    public static void main(String[] args) {
        int[] num = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(num)));
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}
