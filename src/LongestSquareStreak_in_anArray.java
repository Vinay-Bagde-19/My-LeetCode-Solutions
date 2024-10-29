import java.util.Arrays;
/** Problem No. 2501 Medium
 https://leetcode.com/problems/longest-square-streak-in-an-array/description/

 You are given an integer array nums. A subsequence of nums is called a square streak if:
 The length of the subsequence is at least 2, and
 after sorting the subsequence, each element (except the first element) is the square of the previous number.
 Return the length of the longest square streak in nums, or return -1 if there is no square streak.

 A subsequence is an array that can be derived from another array by deleting some or no elements without changing
 the order of the remaining elements.

 Example 1:
 Input: nums = [4,3,6,16,8,2]
 Output: 3
 Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
 - 4 = 2 * 2.
 - 16 = 4 * 4.
 Therefore, [4,16,2] is a square streak.
 It can be shown that every subsequence of length 4 is not a square streak.

 Example 2:
 Input: nums = [2,3,5,6,7]
 Output: -1
 Explanation: There is no square streak in nums so return -1.
 */
public class LongestSquareStreak_in_anArray {
    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }

    /* Done using Binary Search after sorting array.
     *First Sort the given array nums. Set longestStreak = 0,
     *Now run a for loop to itrate over every value. Inside this set count = 1 (which get reset for every value of i)
     and num = nums[i]. *Now run a While loop while it is true, set start = i, end = nums.length-1, boolean
     found = false. **Now Inside the previous while run another While loop (start <= end) find mid , check
            #IF(nums[mid] == num * num) set count++, num = nums[mid], start = mid+1 and found=true and break the loop.
            #Else if (nums[mid] < num * num) set start = mid+1.
            #Else end = mid-1.
        #IF after the while loop get over it does not found a square, the 'found' we have set to false will be as it is
        so make it true using (!found)  and break (which will end the outer while loop, since it was true all time.)
     After both while loop end set longestStreak = Math.max(longestStreak, count).
  and after the for loop get over check if (longestStreak > 1) then return longestStreak Else return -1.
     */
    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];

            while (true) {
                int start = i;
                int end = nums.length - 1;
                boolean found = false;

                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] == num * num) {
                        count++;
                        num = nums[mid];
                        start = mid + 1;
                        found = true;
                        break;
                    } else if (nums[mid] < num * num) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                if (!found) break;
            }

            longestStreak = Math.max(longestStreak, count);
        }

        return longestStreak;
    }

}
