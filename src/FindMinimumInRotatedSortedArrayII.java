/** Problem No. 154 Hard
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

 Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 For example, the array nums = [0,1,4,4,5,6,7] might become:
 [4,5,6,7,0,1,4] if it was rotated 4 times.
 [0,1,4,4,5,6,7] if it was rotated 7 times.
 Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
 [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 You must decrease the overall operation steps as much as possible.

 Example 1:
 Input: nums = [1,3,5]
 Output: 1

 Example 2:
 Input: nums = [2,2,2,0,1]
 Output: 0
 */
public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            // Check if mid = start = end than reduce the search area
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
