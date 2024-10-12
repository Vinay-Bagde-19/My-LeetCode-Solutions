import java.util.Arrays;

/** Problem No. 1
https://leetcode.com/problems/two-sum/description/
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

        public static int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] == target - nums[i]){
                        return new int[] {i, j};
                    }
                }
            }
            return new int[] {};
        }
}
