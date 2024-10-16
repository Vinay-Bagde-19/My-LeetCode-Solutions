import java.util.Arrays;

/** Problem No. 34 Medium
 https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

 Given an array of integers nums sorted in non-decreasing order,
 find the starting and ending position of a given target value.
 If target is not found in the array, return [-1, -1].
 You must write an algorithm with O(log n) runtime complexity.

 Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]

 Example 3:
 Input: nums = [], target = 0
 Output: [-1,-1]
 */
public class FindFirst_andLastPosition_ofElement_inSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    //Use Binary Search : make a function that take nums[], target, and findStartIndex which is a boolean value,
    // in this set ans = -1, start = 0, end = length -1, do binary search same but when we find mid = target
    // set ans = mid and now check if(findStartIndex) then do end = mid-1 or else start = mid +1 and at last return
    // the value of ans. Now call this function to find start and end and return it in ans[].
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target < nums[mid]){
                end = mid - 1;
            } else if(target > nums[mid]){
                start = mid + 1;
            }else{
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }else {
                    start = mid +1;
                }
            }
        }
        return ans;
    }
}
