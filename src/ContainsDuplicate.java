import java.util.Arrays;

/** Problem No. 217
 https://leetcode.com/problems/contains-duplicate/description/

 Given an integer array nums, return true if any value appears at least twice in the array, and return false if
 every element is distinct.

 Example 1:
 Input: nums = [1,2,3,1]
 Output: true
 Explanation:
 The element 1 occurs at the indices 0 and 3.

 Example 2:
 Input: nums = [1,2,3,4]
 Output: false
 Explanation:
 All elements are distinct.

 Example 3:
 Input: nums = [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){//Check with previous element if it is equal then true
                return true;
            }
        }

        return false;//If no value is repeated than false.
    }
}
