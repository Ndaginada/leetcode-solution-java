package leetcode.solution;

/**
 * 415. 字符串相加
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * Solution: 双指针逐位相加  add变量表示进位
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int add = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || add != 0;
             i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 :  num2.charAt(j) - '0';

            int sum = (a + b + add) % 10;
            res.append(sum);
            add =  (a + b + add) / 10;
        }

        return res.reverse().toString();
    }


    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        System.out.println(solution415.addStrings("1", "9"));
    }

}
