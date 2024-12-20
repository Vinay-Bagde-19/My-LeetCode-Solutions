/** Problem no. 1752
 https://leetcode.com/problems/max-consecutive-ones/description/

 Given a binary array nums, return the maximum number of consecutive 1's in the array.

 Example 1:
 Input: nums = [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive
 1s is 3.

 Example 2:
 Input: nums = [1,0,1,1,0,1]
 Output: 2
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for(int i : nums){
            if(i == 1){
                count++;
            }else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
