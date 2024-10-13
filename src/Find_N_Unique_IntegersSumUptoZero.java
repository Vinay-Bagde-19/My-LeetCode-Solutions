import java.util.Arrays;

/** Problem No. 1304
 https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/

 Given an integer n, return any array containing n unique integers such that they add up to 0.

 Example 1:
 Input: n = 5
 Output: [-7,-1,1,3,4]
 Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

 Example 2:
 Input: n = 3
 Output: [-1,0,1]

 Example 3:
 Input: n = 1
 Output: [0]
 */
public class Find_N_Unique_IntegersSumUptoZero {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    /**set end = n-1, then check if n % 2 != 0
     * if yes set ans[0] = 0 and use for loop from start = 1 to start < end in this set ans[start] = start
     and ans[end--] = start * -1 (here end is used first the decrement)
     * if No then use for loop from start = 0 to start < end in this set ans[start] = 1 + start
     and ans[end--] = (1 + start) * -1
     */
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        int end = n - 1;
        if (n % 2 != 0) {
            ans[0] = 0;
            for (int start = 1; start < end; start++) {
                ans[start] = start;
                ans[end--] = start * -1;
            }
        }else {
            for (int start = 0; start < end; start++) {
                ans[start] = 1 + start;
                ans[end--] = (1 + start) * -1;
            }
        }
        return ans;
    }
}
