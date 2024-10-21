import java.util.Arrays;

/** Problem No. 189 Medium
 https://leetcode.com/problems/rotate-array/description/

 Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 Example 1:
 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]

 Example 2:
 Input: nums = [-1,-100,3,99], k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int rotate = 3;
        rotate(nums, rotate);
        System.out.println(Arrays.toString(nums));
    }

    //First find the real rotations to make, k = k % nums.length (ex. If length=7 and k is given 9 then the real
    // rotations we have to make are 9%7= 2). Then do this three steps to get the answer :
    // First Reverse the whole array,
    // Second Reverse the array from 0 to k-1 (here k value is the remainder one).
    // Third Reverse the array from k to nums.length-1.
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
