/** Problem No. 1295
 https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

 Example 1:
 Input: nums = [12,345,2,6,7896]
 Output: 2
 Explanation:
 12 contains 2 digits (even number of digits).
 345 contains 3 digits (odd number of digits).
 2 contains 1 digit (odd number of digits).
 6 contains 1 digit (odd number of digits).
 7896 contains 4 digits (even number of digits).
 Therefore only 12 and 7896 contain an even number of digits.

 Example 2:
 Input: nums = [555,901,482,1771]
 Output: 1
 Explanation:
 Only 1771 contains an even number of digits.
 */
public class Find_Numbers_With_Even_Number_of_Digits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
//increment count if digits % 2 = 0 and for finding number of digits do nums[i] = nums[i] /10 while nums[i] > 0
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int digits = 0;
            while(nums[i] > 0){
                digits++;
                nums[i] = nums[i] / 10;
            }
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
