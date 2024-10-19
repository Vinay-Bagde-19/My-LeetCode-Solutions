/** Problem No. 33 Medium
 https://leetcode.com/problems/search-in-rotated-sorted-array/description/

 There is an integer array nums sorted in ascending order (with distinct values).
 Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 Given the array nums after the possible rotation and an integer target, return the index of target if it is in
 nums, or -1 if it is not in nums.

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4

 Example 2:
 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 Example 3:
 Input: nums = [1], target = 0
 Output: -1
 */
public class Search_InRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
        System.out.println(search(arr, 0));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        //if you did not find a pivot, it means the array is not rotated
        if (pivot == -1){
            // just do normal binary search
            return binarySearch(nums, target, 0, nums.length-1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target){
            return pivot;
        } else if (nums[pivot] > target) {
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }else {
            return binarySearch(nums, target, 0, pivot-1);
        }
    }

    //Use this when array does not contain duplicate elements
    static int findPivot(int[] arr){
        int start =  0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            //Case 1
            if (mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            //Case 2
            if (mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            //Case 3
            if (arr[mid] <= arr[start]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    //Use this when array contains duplicate elements
    static int findPivotWithDuplicates(int[] arr){
        int start =  0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            //Case 1
            if (mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            //Case 2
            if (mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            // If elements at middle, start and end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
                //Skip the duplicates

                // NOTE: what if these elements at start and end were the pivot??
                // Check if start is pivot
                if (arr[start] > arr[start+1]){
                    return start;
                }
                start++;

                //check if end is pivot
                if (arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
