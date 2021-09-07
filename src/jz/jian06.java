package jz;

import Common.ListNode;

import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/9/7 下午1:36
 * @ClassName jian06
 * @Description 从头到尾打印链表
 */

public class jian06 {

    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode p = head;
            int l = 0;
            while (p != null){
                l++;
                p = p.next;
            }
            int[] ans = new int[l];
            p = head;
            while (p != null){
                ans[l-1] = p.val;
                l--;
                p = p.next;
            }
            return ans;
        }
    }

    public int[] reversePrint(ListNode head) {
        int[] ints = new Solution().reversePrint(head);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        return ints;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1,2,3,4,5});
        new jian06().reversePrint(listNode );
    }
}

