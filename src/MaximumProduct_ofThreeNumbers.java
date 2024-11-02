import java.util.Arrays;
/** Problem No. 628
 https://leetcode.com/problems/maximum-product-of-three-numbers/description/

 Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 Example 1:
 Input: nums = [1,2,3]
 Output: 6

 Example 2:
 Input: nums = [1,2,3,4]
 Output: 24

 Example 3:
 Input: nums = [-1,-2,-3]
 Output: -6
 */
public class MaximumProduct_ofThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(maximumProduct(nums));
        int[] numsWithNegativeValues = {-100,-98,1,2,3,4};
        System.out.println(maximumProduct(numsWithNegativeValues));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(maxProduct1, maxProduct2);
    }

}
