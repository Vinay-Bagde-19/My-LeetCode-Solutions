import java.util.Arrays;

/** Problem No. 1480
 https://leetcode.com/problems/concatenation-of-array/description/

 Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and
 ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 Specifically, ans is the concatenation of two nums arrays.
 Return the array ans.

 Example 1:
 Input: nums = [1,2,1]
 Output: [1,2,1,1,2,1]
 Explanation: The array ans is formed as follows:
 - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 - ans = [1,2,1,1,2,1]

 Example 2:
 Input: nums = [1,3,2,1]
 Output: [1,3,2,1,1,3,2,1]
 Explanation: The array ans is formed as follows:
 - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 - ans = [1,3,2,1,1,3,2,1]
 */
public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[ n * 2];
        for(int i = 0; i < n; i++){
            //Copy the same element in i and i+n position "where n is the number of element in the nums array
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }
}
