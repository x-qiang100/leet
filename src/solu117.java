/**
 * @author xq
 * @Date 2021/8/11 下午5:26
 * @ClassName solu117
 * @Description 填充每一个节点的下一个右侧节点指针
 */

/*
《编程之美》上这样说:

    设N = abcde ,其中abcde分别为十进制中各位上的数字。
    如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
    如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。注意：高位数字不包括当前位
    如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个。和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一共14个，等于低位数字（13）+1。 注意：低位数字不包括当前数字
    如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）
 */
public class solu117 {

    class Solution {
        public Node connect(Node root) {
            if(root == null) return root;
            dfs(root);
            return root;
        }

        void dfs(Node root){
            if(root == null) return;
            if(root.left == null && root.right == null){
                return;
            }
            if(root.left != null && root.right!= null){
                root.left.next = root.right;
            }

            if(root.next == null) {
                dfs(root.right);
                dfs(root.left);
                return;
            }

            Node q = root;
            Node p = root;
            while (p.next != null) {
                p = p.next;
                if (p.left != null || p.right != null) {
                    break;
                }
            }

            Node pre = q.right;
            Node post = p.left;
            if (pre == null) {
                pre = q.left;
            }
            if (post == null) {
                post = p.right;
            }
            pre.next = post;
            q = p;

            dfs(root.right);
            dfs(root.left);
        }
    }
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

    public Node connect() {
        Node root = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        root.left = root2;
        root.right = root3;
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        root2.left = root4;
        root2.right = root5;
        Node root6 = new Node(6);
        root3.right = root6;
//        Node root7 = new Node(7);
//        Node root8 = new Node(8);
//        Node root9 = new Node(9);
//        root4.left = root7;
//        root5.left = root8;
//        root6.right = root9;

        Node connect = new Solution().connect(root);
//        System.out.println("connect.next = " + connect.next);
        System.out.println("connect.left.right.next.val = " + connect.left.left.next.next.next.val);
        return connect;
    }


    public static void main(String[] args) {
//        Node connect = new Solution().connect(root);
        new solu117().connect();
    }

}

