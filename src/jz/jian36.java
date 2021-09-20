package jz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/20 13:51
 * ClassName:jian36
 * Package:jz
 * Description:
 */
public class jian36 {
    class Solution {
        List<Node> list;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            list = new ArrayList<>();
            dfs(root);
            Node head = list.get(0);
            Node p =head;
            for (int i = 1; i < list.size(); i++) {
                p.right = list.get(i);
                list.get(i).left = p;
                p = list.get(i);
            }
            p.right = head;
            head.left = p;
            return head;
        }

        void dfs(Node node){
            if(node == null) return;
            dfs(node.left );
            list.add(node );
            dfs(node.right );
        }
    }

    void test(){
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        final Node node = new Solution().treeToDoublyList(n1);
        Node p = node;
        int flag = 1;
        while (p != node || flag == 1){
            flag =0;
            System.out.println("p.val = " + p.val);
            System.out.println("p.left.val = " + p.left.val);
            System.out.println("p.right.val = " + p.right.val);
            System.out.println();
            p = p.right;
        }
    }
    public static void main(String[] args) {
        new jian36().test();
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
