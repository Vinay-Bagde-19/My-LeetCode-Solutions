import java.util.Arrays;
/** Problem No. 169
 https://leetcode.com/problems/majority-element/

 Given an array nums of size n, return the majority element.
 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 always exists in the array.

 Example 1:
 Input: nums = [3,2,3]
 Output: 3

 Example 2:
 Input: nums = [2,2,1,1,1,2,2]
 Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        int mid = start + (end - start)/2;
        return nums[mid];
    }
}
