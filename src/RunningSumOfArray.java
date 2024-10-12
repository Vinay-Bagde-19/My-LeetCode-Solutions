import java.util.Arrays;

/** Problem No. 1480
 https://leetcode.com/problems/running-sum-of-1d-array/description/

 Example 1:
 Input: nums = [1,2,3,4]
 Output: [1,3,6,10]
 Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

 Example 2:
 Input: nums = [1,1,1,1,1]
 Output: [1,2,3,4,5]
 Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

 Example 3:
 Input: nums = [3,1,2,10,1]
 Output: [3,4,6,16,17]
 */
public class RunningSumOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    //Make use of two pointers prev, next
    public static int[] runningSum(int[] nums) {
        int prev = 0;
        for(int next = 1; next < nums.length; next++){
            nums[next] = nums[prev] + nums[next];
            prev++;
        }
        return nums;
    }
}
