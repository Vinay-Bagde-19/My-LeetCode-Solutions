/** Problem No. 81 Medium
 https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

 There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that
 the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

 Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is
 not in nums.
 You must decrease the overall operation steps as much as possible.

 Example 1:
 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true

 Example 2:
 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 */

public class Search_inRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    //Use Binary Search: s=0, e=nums.length-1. While(s <= e) find mid and If mid element = target return true,
    // or If element at mid = element at s = element at e then make s++ and e-- (Handle duplicates).
    // # Else if element at s <= mid (Left sorted) ->
    //         if (nums[s] <= target && target <= nums[mid]) Set e = mid-1
    //              Else s=mid+1.
    // # Else (it is Right sorted) ->
    //          if (nums[mid] <= target && target <= nums[e]) Set s=mid+1
    //          Else e=mid-1.

    public static boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // Handle duplicates
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
            } else if (nums[s] <= nums[mid]) {// Left sorted
                if (nums[s] <= target && target <= nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {// Right sorted
                if (nums[mid] <= target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return false;
    }
}
