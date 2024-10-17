/** Problem No. 367
 https://leetcode.com/problems/valid-perfect-square/submissions/1424123411/

 Given a positive integer num, return true if num is a perfect square or false otherwise.
 A perfect square is an integer that is the square of an integer. In other words,
 it is the product of some integer with itself.
 You must not use any built-in library function, such as sqrt.

 Example 1:
 Input: num = 16
 Output: true
 Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

 Example 2:
 Input: num = 14
 Output: false
 Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        int start = 2;
        int end = num / 2;

        while(start <= end){
            int mid = start + (end - start)/2;
            long square = (long) mid * mid; // To avoid overflow
            if (square == num) {
                return true;
            } else if (square < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
