/**
 * @author xq
 * @Date 2021/8/11 下午3:57
 * @ClassName solu116
 * @Description 填充每个节点的下一个右侧节点指针
 */

public class solu116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if(root == null) return root;
            dfs(root );
            return root;
        }
        void dfs(Node root){
            if(root.left == null) return;

            root.left.next = root.right;
            root.right.next = null;

            dfs(root.left);
            dfs(root.right);

            Node node1 = root.left;
            Node node2 = root.right;
            while (node1 != null ){
                node1.next = node2;
                node1 = node1.right;
                node2 = node2.left;
            }
        }

    }

    public Node connect(Node root) {

        Node connect = new Solution().connect(root);
        System.out.println("connect = " + connect);
        return connect;
    }
    public static void main(String[] args) {

    }


}

