//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 265 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        /**
         * 使用键值对 Key：某个字符 Value：是否只出现一次
         * 对sc进行两次循环就可以得出答案
         */
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc=s.toCharArray();
        for (char c:sc)
            dic.put(c,!dic.containsKey(c));
        for (char c:sc)
            if(dic.get(c))
                return c;
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
