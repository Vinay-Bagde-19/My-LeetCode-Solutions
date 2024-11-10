/** Problem on GeeksForGeeks
 https://www.geeksforgeeks.org/problems/second-largest3735/1

 Given an array arr[], return the second largest element from an array. If the
 second largest element doesn't exist then return -1.
 Note: The second largest element should not be equal to the first largest.

 Examples:
 Input: arr[] = [12, 35, 1, 10, 34, 1]
 Output: 34
 Explanation: The largest element of the array is 35 and the second largest element is 34.

 Input: arr[] = [10, 10]
 Output: -1
 Explanation: The largest element of the array is 10 and the second largest element does not exist..
 */
public class SecondLargestElement_in_anArrayWithoutSorting {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {
        int max2 = -1;
        int max = arr[0];

        for(int i : arr){
            if(i > max){
                max2 = max;
                max = i;
            }else if(i < max && i > max2){
                max2 = i;
            }
        }
        return max2;
    }
}
