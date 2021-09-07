package jz;

import Common.ListNode;

/**
 * @author xq
 * @Date 2021/9/7 下午1:48
 * @ClassName jian24
 * @Description 反转链表
 */

public class jian24 {

    //迭代
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null) return head;
            ListNode p = head;
            ListNode t = head;
            ListNode q = head.next;
            while ( q!= null){
                p.next = q.next;
                q.next = t;

                t = q;
                q = p.next;
            }
            return t;
        }
    }

    //递归
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            return f(head);
        }

        ListNode f(ListNode head){
            if(head == null || head.next == null) return head;
            ListNode newHead = f(head.next );
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    }
    public void test(){
        ListNode listNode = ListNode.create(new int[]{1, 2,3,4,5});
        ListNode t = new Solution2().reverseList(listNode);
        ListNode.show(t);
    }

    public static void main(String[] args) {
        new jian24().test();
    }
}

