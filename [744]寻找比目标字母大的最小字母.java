//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 104 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 
// 👍 244 👎 0


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        /**
         * 用的是TreeSet
         * 在添加的时候就把元素按从小到大排序
         * E first();返回此集合中当前的第一个（最低）元素。
         * E higher(E e);返回这个集合中的最小元素严格大于给定的元素，如果没有这样的元素，则返回null。
         */
        TreeSet set = new TreeSet();
        for (int i = 0; i < letters.length; i++) {
            set.add(letters[i]);
        }

        if(set.higher(target)==null){
            return (char)set.first();
        }else {
            return (char)set.higher(target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
