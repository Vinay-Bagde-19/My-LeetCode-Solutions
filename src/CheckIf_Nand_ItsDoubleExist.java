import java.util.Arrays;

/** Problem No. 1346
 https://leetcode.com/problems/check-if-n-and-its-double-exist/description/

 Given an array arr of integers, check if there exist two indices i and j such that :

 i != j
 0 <= i, j < arr.length
 arr[i] == 2 * arr[j]

 Example 1:
 Input: arr = [10,2,5,3]
 Output: true
 Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

 Example 2:
 Input: arr = [3,1,7,11]
 Output: false
 Explanation: There is no i and j that satisfy the conditions.
 */
public class CheckIf_Nand_ItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int start = 0;
            int end = arr.length-1;
            int target = arr[i] * 2;
            while(start <= end){
                int mid = start + (end - start)/2;

                if(arr[mid] == target && mid != i){
                    return true;
                }
                else if(arr[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
