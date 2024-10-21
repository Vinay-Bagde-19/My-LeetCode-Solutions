import java.util.Arrays;

/** Problem No. 75 Medium
 https://leetcode.com/problems/sort-colors/

 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
 color are adjacent, with the colors in the order red, white, and blue.
 We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 You must solve this problem without using the library's sort function.

 Example 1:
 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

 Example 2:
 Input: nums = [2,0,1]
 Output: [0,1,2]
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Use three pointers: w=0,r=0 and b=length-1. Run a loop while w<=b, If nums[w] == 2 swap with b
    // (Since blue will be at right and all 2's also) and b--, Else if nums[w] == 0 swap with r and make r++ and w++,
    // Else make w++(which will happen if w == 1).
    public static void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = nums.length-1;
        while(w <= b){
            if(nums[w] == 2){
                int temp = nums[b];
                nums[b] = nums[w];
                nums[w] = temp;
                b--;
            }else if(nums[w] == 0){
                int temp = nums[w];
                nums[w] = nums[r];
                nums[r] = temp;
                w++;
                r++;
            }else{
                w++;
            }
        }
    }
}
