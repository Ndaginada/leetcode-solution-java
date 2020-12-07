package leetcode.solution;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * <p>
 * 示例：
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * Solution: 使用栈，初始放入一个!，防止pop抛异常，在使用一个map存放括号组合
 *           之后将开始括号挨个入栈，若是其它符号则出栈，如果出栈元素为!或对应不上括号则提前返回false
 *           最后判断栈如果还有其它元素则返回false
 */
public class Solution20 {

    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('{','}');
        charMap.put('[',']');
        charMap.put('(',')');

        Deque<Character> stack = new LinkedList<>();
        stack.push('!');

        for (Character c :
             s.toCharArray()) {
            if (charMap.containsKey(c)) {
                stack.push(c);
            } else {
                Character popChar = stack.pop();
                if (popChar == '!' || !c.equals(charMap.get(popChar))) {
                    return false;
                }
            }
        }

        return stack.peek() == null || stack.peek() == '!';
    }

    public static void main(String[] args) {
        Solution20 solution21 = new Solution20();
        System.out.println(solution21.isValid("(("));

    }


}
