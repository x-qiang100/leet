import Common.TreeNode;

/**
 * @author xq
 * @Date 2021/8/2 下午6:34
 * @ClassName solu98
 * @Description 验证二叉搜索树
 */

public class solu98 {
    class Solution {
        long v = Long.MIN_VALUE;
        boolean b = true;
        public boolean isValidBST(TreeNode root) {
            mid(root );
            return b;
        }

        void mid(TreeNode node) {
            if (node == null) {
                return ;
            }
            mid(node.left);
            if (node.val <= v) {
                b = false;
            }
            v = node.val;
            mid(node.right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        boolean validBST = new Solution().isValidBST(root);
        System.out.println("validBST = " + validBST);
        return validBST;
    }

    public static void main(String[] args) {
        solu98 s = new solu98();
        TreeNode root = TreeNode.create(new Integer[]{
//                2, 1, 3
//                5,1,4,null,null,3,6
//                0,-1
                5,4,6,null,null,3,7
        });
        s.isValidBST(root);
    }

}

