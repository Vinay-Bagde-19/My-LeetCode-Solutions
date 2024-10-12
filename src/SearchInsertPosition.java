/** Problem No. 35
 https://leetcode.com/problems/search-insert-position/description/

 example1:
 Input: nums = [1,3,5,6], target = 2
 Output: 1

 example2:
 Input: nums = [1,3,5,6], target = 7
 Output: 4
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println("The index at which the target element is or will be : "
                + searchInsert(nums, target));
    }
        public static int searchInsert(int[] nums, int target) {
            for(int i=0; i < nums.length; i++){
                if(nums[i] < target && i == nums.length-1){
                    return i+1;
                }
                if(nums[i] == target || nums[i] > target){
                    return i;
                }
            }
            return -1;
        }
}
