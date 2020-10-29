package leetcode.solution;

/**
 * 53. 最大子序和
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * Solution：通过一个变量pre记录之前最大和，遍历数组，如果pre加上当前值小于当前值就将当前值赋给pre，最后取得最大的pre就是结果
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int pre = 0;

        for (int num : nums) {
            pre = Math.max(num, pre + num);
            res = Math.max(pre, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution53.maxSubArray(a));
    }


}
