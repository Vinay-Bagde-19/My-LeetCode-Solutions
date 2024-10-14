/** Problem No. 1281
 https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/

 Example 1:
 Input: n = 234
 Output: 15
 Explanation:
 Product of digits = 2 * 3 * 4 = 24
 Sum of digits = 2 + 3 + 4 = 9
 Result = 24 - 9 = 15

 Example 2:
 Input: n = 4421
 Output: 21
 Explanation:
 Product of digits = 4 * 4 * 2 * 1 = 32
 Sum of digits = 4 + 4 + 2 + 1 = 11
 Result = 32 - 11 = 21
 */
public class Subtract_theProduct_andSum_ofDigits_ofInteger {
    public static void main(String[] args) {
        int n = 234;
        System.out.println(subtractProductAndSum(n));
    }
    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int pro = 1;
        while(n > 0){
            int digit = n % 10;
            sum = sum + digit;
            pro = pro * digit;
            n = n/10;
        }
        return pro - sum;
    }
}
