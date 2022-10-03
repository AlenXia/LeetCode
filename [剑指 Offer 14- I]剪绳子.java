//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        /**
         * dp数组记录0~n长度的绳子减掉后的最大乘积，dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化ap[2]=1
         * 先减掉长度为j的绳子
         * 剩下(i-j)长度可以剪也可以不剪。
         * 如果不剪，长度乘积为j * (i - j)
         * 如果减去，长度为j * dp[i - j])
         * 取两者最大值
         */
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i],
                        Math.max(j * (i - j), j * dp[i - j])
                );
            }
        }
        return dp[n];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
