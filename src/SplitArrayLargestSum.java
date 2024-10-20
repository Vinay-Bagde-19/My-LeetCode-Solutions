/** Problem No. 410 Hard
 https://leetcode.com/problems/split-array-largest-sum/

 Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any
 subarray is minimized.

 Return the minimized largest sum of the split.

 A subarray is a contiguous part of the array.

 Example 1:
 Input: nums = [7,2,5,10,8], k = 2
 Output: 18
 Explanation: There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

 Example 2:
 Input: nums = [1,2,3,4,5], k = 2
 Output: 9
 Explanation: There are four ways to split nums into two subarrays.
 The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        //our Minimum possible answer can be max value of the array if k = n where n is length we have to
        // make n partitions.
        //And Maximum possible answer can be sum of the array if k = 1 we have to make only 1 partitions that is
        // the array itself.
        int start = 0;
        int end = 0;

        //Find max for start and sum for end
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item in the array
            end += nums[i];
        }

        //Do Binary Search after getting the range that is from start till end.
        while (start < end){
            //try for the middle as potential ans
            int mid = start + (end - start)/2;

            //Calculate how many pieces we can divide in this, with this mid as the max sum.
            int sum = 0;
            int pieces = 1;

            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid){
                    //We can not add more in this sub-array, we need to make a new sub-array.
                    //if we make a new sub-array then, sum = nums[i] for that new array and continue loop
                    sum = nums[i];
                    pieces++;//new sub-array is created
                } else{
                    sum = sum + nums[i];
                }
            }

            if (pieces > k){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return end;//Here we can return start, end since after the loop is over they all will be pointing to same element.
    }
}
