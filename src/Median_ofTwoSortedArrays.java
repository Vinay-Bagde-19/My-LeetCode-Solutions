/** Problem No. 4 Hard
 https://leetcode.com/problems/median-of-two-sorted-arrays/

 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 The overall run time complexity should be O(log (m+n)).

 Example 1:
 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.

 Example 2:
 Input: nums1 = [1,2], nums2 = [3,4]
 Output: 2.50000
 Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class Median_ofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = merge(nums1, nums2);
        double median;
        int end = ans.length - 1;
        int start = 0;
        int mid = start + (end - start)/2;
        if(ans.length % 2 == 0){
            median = (double)(ans[mid] + ans[mid+1]) / 2;
        }else{
            median = ans[mid];
        }
        return median;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1, if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2, if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
}
