package leetcode.solution;

/**
 * 70. 爬楼梯
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * Solution：拿4阶举例，可以先跳1阶或先跳2阶，先跳1阶还剩3阶，先跳2阶还剩2阶，所以4阶最大次数就是3阶次数+2阶次数，
 *           这样就拆分为了重叠的子问题，用动态规划的思路就可以解决，f(n) = f(n - 2) + f(n - 1)
 *           发现是斐波那契数列，也可以套公式解。
 */
public class Solution70 {

    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        //由于只需要计算三个状态，可以采用滚动数组
        int q = 1;
        int w = 2;
        for (int i = 2; i < n; i++) {
            int r = q + w;
            q = w;
            w = r;
        }
        return w;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(5));
    }


}
