/** Problem no. 9
 https://leetcode.com/problems/palindrome-number/description/

 Given an integer x, return true if x is a palindrome, and false otherwise.

 Example 1:
 Input: x = 121
 Output: true
 Explanation: 121 reads as 121 from left to right and from right to left.

 Example 2:
 Input: x = -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

 Example 3:
 Input: x = 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        int revers=0;
        int original=x;
        if(x<0){
            return false;
        }
        if(x==0 || x > 0 && x < 10){
            return true;
        }
        while(x!=0){
            int rem=x%10;
            revers=revers*10+rem;
            x/=10;
        }
        return (revers==original);
    }
}
