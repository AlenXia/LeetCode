//有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i]
// 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 
//
// 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。 
//
// 请你返回 这一天营业下来，最多有多少客户能够感到满意 。 
// 
//
// 示例 1： 
//
// 
//输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//输出：16
//解释：书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 示例 2： 
//
// 
//输入：customers = [1], grumpy = [0], minutes = 1
//输出：1 
//
// 
//
// 提示： 
//
// 
// n == customers.length == grumpy.length 
// 1 <= minutes <= n <= 2 * 104 
// 0 <= customers[i] <= 1000 
// grumpy[i] == 0 or 1 
// 
// Related Topics 数组 滑动窗口 
// 👍 238 👎 0


import sun.util.resources.cldr.sn.CurrencyNames_sn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        /**
         * 滑动窗口
         * 定义一个minutes大小的窗口
         * 从最左边向右边滑动 滑动的同时进行加减
         */

        int sum = 0;          // 不控制情绪有多少顾客满意
        int increase = 0;     // 当前窗口能增加多少顾客满意
        int maxIncrease = 0;  // 最大能增加的顾客满意

        // 计算正常情况下有多少顾客满意
        for (int i = 0; i < customers.length; ++i) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        // 老板在第一个窗口发动技能 增加的顾客满意
        for (int i = 0; i < minutes; ++i) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
        }

        maxIncrease = increase;

        // 窗口右移
        // 如果右边是不满意的顾客 那么就加上
        // 如果左边是不满意的顾客 那么就减去
        for (int i = minutes; i < customers.length; ++i) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                increase -= customers[i - minutes];
            }
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return maxIncrease + sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
