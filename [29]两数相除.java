//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 
// 👍 987 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        // 判断divisor为1的情况
        if (divisor == 1) {
            return dividend;
        }
        // 判断是否越界
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE)
                return -dividend;
            else
                return Integer.MAX_VALUE;
        }
        // 转化为long防止越界
        long tmpDividend = Math.abs((long) dividend);
        long tmpDivisor = Math.abs((long) divisor);
        long result = 0;
        // 用减法来做
        while (tmpDividend >= tmpDivisor) {
            tmpDividend -= tmpDivisor;
            result++;
        }
        // 最后判断结果的正负值
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return (int) result;
        else
            return -(int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
