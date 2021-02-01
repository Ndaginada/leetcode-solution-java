package leetcode.solution;

/**
 * 389. 找不同
 * <p>
 * https://leetcode-cn.com/problems/find-the-difference/
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * Solution: 将两个ASCII码相减 就是被添加的字母元素
 */
public class Solution389 {

    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        int snum = 0, tnum = 0;

        for (int i = 0; i < s.length(); i++) {
            snum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tnum += t.charAt(i);
        }

        return (char) (tnum - snum);
    }

    public static void main(String[] args) {


        Solution389 solution121 = new Solution389();


        System.out.println(solution121.findTheDifference("abc", "cbax"));
    }


}
