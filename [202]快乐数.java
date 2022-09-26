//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 双指针 
// 👍 1074 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 用本函数来获取各位数的平方和
     * @return 平方和
     */
    public static int getNext(int n) {
        int total = 0;
        while (n > 0) {
            // 取个位数
            int d = n % 10;
            // 把个位数删除
            n = n / 10;
            total += d * d;
        }
        return total;
    }

//    // 1.用哈希集合检测循环
//    public boolean isHappy(int n) {
//        /**
//         * HashSet特点：
//         * 底层数据结构是Hash表
//         * 对集合迭代顺序不作任何保证
//         * 不包含重复元素
//         *
//         * 为什么使用HashSet：
//         * 因为我们要不断查询某个值是否存在，检查是否在哈希表中的时间复杂度是O(1)
//         */
//        Set<Integer> seen = new HashSet<>();
//        /**
//         * 在这里做一个判断
//         * 如果 n=1 说明：我们已经找到快乐数
//         * 如果某个n已经存在于seen中，说明：已经陷入了循环
//         */
//        while (n != 1 && !seen.contains(n)) {
//            seen.add(n);
//            n = getNext(n);
//        }
//        return n == 1;
//    }

    // 2.快慢指针法
    public boolean isHappy(int n) {
        /**
         * 使用快慢指针的目的也是为了检测是否出现了循环
         * 兔子始终比乌龟快两拍
         * 如果没有出现循环，兔子会先达到1
         * 如果出现循环，兔子和乌龟最后会在同一个n相遇
         */
        int tortoise = n;
        int rabbit = getNext(n);

        // 开始跑
        while (rabbit != 1 && rabbit != tortoise) {
            tortoise = getNext(tortoise);
            rabbit = getNext(getNext(rabbit));
        }
        return rabbit == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

