/** Problem No. 1957
 https://leetcode.com/problems/delete-characters-to-make-fancy-string/

 A fancy string is a string where no three consecutive characters are equal.
 Given a string s, delete the minimum possible number of characters from s to make it fancy.
 Return the final string after the deletion. It can be shown that the answer will always be unique.

 Example 1:
 Input: s = "leeetcode"
 Output: "leetcode"
 Explanation:
 Remove an 'e' from the first group of 'e's to create "leetcode".
 No three consecutive characters are equal, so return "leetcode".

 Example 2:
 Input: s = "aaabaaaa"
 Output: "aabaa"
 Explanation:
 Remove an 'a' from the first group of 'a's to create "aabaaaa".
 Remove two 'a's from the second group of 'a's to create "aabaa".
 No three consecutive characters are equal, so return "aabaa".

 Example 3:
 Input: s = "aab"
 Output: "aab"
 Explanation: No three consecutive characters are equal, so return "aab".
 */
public class DeleteCharacters_toMakeFancyString {
    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyString(s));
    }

    public static String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            }
            else {
                sameCount = 1;
            }
            if (sameCount < 3) sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}
