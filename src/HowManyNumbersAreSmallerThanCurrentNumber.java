import java.util.Arrays;

/** Problem No. 1365
 https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/

 Example 1:
 Input: nums = [8,1,2,2,3]
 Output: [4,0,1,1,3]
 Explanation:
 For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 For nums[1]=1 does not exist any smaller number than it.
 For nums[2]=2 there exist one smaller number than it (1).
 For nums[3]=2 there exist one smaller number than it (1).
 For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

 Example 2:
 Input: nums = [6,5,4,8]
 Output: [2,1,0,3]

 Example 3:
 Input: nums = [7,7,7,7]
 Output: [0,0,0,0]
 */

public class HowManyNumbersAreSmallerThanCurrentNumber {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

//use double for loop, count the that the current element is greater than how many elements, do same for every element
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
