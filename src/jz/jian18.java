package jz;

import Common.ListNode;

/**
 * @author:xq
 * @date:2021/9/16 20:38
 * ClassName:jian18
 * Package:jz
 * Description:
 */
public class jian18 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode node = head;
            if(node.val == val) return head.next;
            ListNode p = head;
            while (node != null){
                if(node.val == val){
                    p.next = node.next;
                }
                p = node;
                node = node.next;
            }

            return head;
        }
    }
}
