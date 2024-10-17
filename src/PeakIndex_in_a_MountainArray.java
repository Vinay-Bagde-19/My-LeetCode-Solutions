/** Problem No. 852 Medium
 https://leetcode.com/problems/peak-index-in-a-mountain-array/

 You are given an integer mountain array arr of length n where the values increase to a peak element
 and then decrease.
 Return the index of the peak element.
 Your task is to solve it in O(log(n)) time complexity.

 Example 1:
 Input: arr = [0,1,0]
 Output: 1

 Example 2:
 Input: arr = [0,2,1,0]
 Output: 1

 Example 3:
 Input: arr = [0,10,5,2]
 Output: 1
 */
public class PeakIndex_in_a_MountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        // we can see this arr as combination of two sorted arrays one in Asc and other in desc here 0,1 is Asc
        //0 is Desc.
        System.out.println(peakIndexInMountainArray(arr));
    }

    //Use Binary Search: start = 0, end = arr.length-1, Run while start != end(because when start = end
    // it is only one element which is the pick), find mid if it is greater than mid+1 make end = mid
    // (we are in dec part of arr) or else make start = mid + 1 (we are in asc part of arr). after loop get
    // false return start or end since both will be at peak element.
    public static int peakIndexInMountainArray(int[] arr) {
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
