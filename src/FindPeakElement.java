/** Problem No. 162 Medium
 https://leetcode.com/problems/find-peak-element/description/

 A peak element is an element that is strictly greater than its neighbors.
 Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
 peaks, return the index to any of the peaks.
 You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
 greater than a neighbor that is outside the array.

 You must write an algorithm that runs in O(log n) time.

 Example 1:
 Input: nums = [1,2,3,1]
 Output: 2
 Explanation: 3 is a peak element and your function should return the index number 2.

 Example 2:
 Input: nums = [1,2,1,3,5,6,4]
 Output: 5
 Explanation: Your function can return either index number 1 where the peak element is 2,
 or index number 5 where the peak element is 6.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    //Use Binary Search: start = 0, end = arr.length-1, Run while start != end(because when start = end
    // it is only one element which is the pick), find mid if it is greater than mid+1 make end = mid
    // (we are in dec part of arr) or else make start = mid + 1 (we are in asc part of arr). after loop get
    // false return start or end since both will be at peak element.
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid + 1] < arr[mid]){
                //we are in dec part
                end = mid;
            }else{
                //we are in Asc part
                start = mid + 1;
            }
        }
        return start;
    }
}