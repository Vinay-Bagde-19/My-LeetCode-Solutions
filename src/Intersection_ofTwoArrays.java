import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/** Problem No. 349
 https://leetcode.com/problems/intersection-of-two-arrays/

 Given two integer arrays nums1 and nums2, return an array of their
 intersection. Each element in the result must be unique and you may return the result in any order.

 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Explanation: [4,9] is also accepted.
 */
public class Intersection_ofTwoArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(Arrays.toString(intersection(num1, num2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        List<Integer> tempResult = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                // Add the element to the result list
                tempResult.add(nums1[i]);

                // Move to the next different element in both arrays
                while (i < n - 1 && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                while (j < m - 1 && nums2[j] == nums2[j + 1]) {
                    j++;
                }

                // Move to the next element
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert the list to an array
        int[] result = new int[tempResult.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = tempResult.get(k);
        }

        return result;
    }
}
