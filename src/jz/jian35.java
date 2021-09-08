package jz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/9/8 下午5:53
 * @ClassName jian35
 * @Description 复杂链表的复制
 */

public class jian35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            List<Node> oldList = new ArrayList<>();
            List<Node> newList = new ArrayList<>();
            Node p = head;
            while ( p != null){
                oldList.add(p);
                Node n = new Node(p.val );

                newList.add(n );
                Node q = p;

                p = p.next;
                q.next = n;
            }

            int l = oldList.size();
            for (int i = 0; i < l; i++) {
                if(oldList.get(i).random == null){
                    newList.get(i).random = null;
                }else {
                    newList.get(i).random = oldList.get(i).random.next;
                }
            }
            for (int i = 1; i < l; i++) {
                newList.get(i-1).next = newList.get(i);
                oldList.get(i-1).next = oldList.get(i);
            }

            oldList.get(l-1).next = null;
            return newList.get(0);
        }
    }
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n1.random = null;
        n2.random = n1;
        n3.random = n1;

        Node l = new Solution().copyRandomList(new Node(10));

        n1.val = 7;
        n2.val = 8;
        n3.val = 9;
//        l=n1;
        System.out.println("l.val = " + l.val);
        System.out.println("l.val = " + l.next.val);
        System.out.println("l.val = " + l.next.next.next);

        System.out.println("l.val = " + l.val);
        System.out.println("l.val = " + l.next.random.val);
        System.out.println("l.val = " + l.next.val);


    }

    public static void main(String[] args) {
        new jian35().test();
    }

}

