package jz;

import Common.ListNode;

/**
 * @author:xq
 * @date:2021/9/16 20:43
 * ClassName:jian22
 * Package:jz
 * Description:
 */
public class jian22 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode node = head;
            int length = 0;
            while (node != null){
                node = node.next;
                length++;
            }

            int n = length - k;
            node = head;
            for (int i = 0; i < n; i++) {
                node = node.next;
            }

            return node;
        }
    }
}
