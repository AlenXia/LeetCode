//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        /**
         * 如果给我一个空链表
         * 我就返回一个空数组
         * int[] a = {}
         */
        if (head == null) {
            int[] a = {};
            return a;
        }
        /**
         * 定义一个ArrayList
         * 遍历链表进行add
         */
        List<Integer> arr = new ArrayList<Integer>();
        while (true) {
            if (head.next == null) {
                arr.add(head.val);
                break;
            }
            arr.add(head.val);
            head = head.next;
        }
        // 使用reverse把ArrayList进行翻转
        Collections.reverse(arr);
        // 把ArrayList转为int[]
        final int size = arr.size();
        Integer[] rev = arr.toArray(new Integer[size]);
        int[] num = Arrays.stream(rev).mapToInt(Integer::valueOf).toArray();
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
