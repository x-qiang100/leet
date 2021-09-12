package jz;

import Common.TreeNode;

/**
 * @author xq
 * @Date 2021/9/12 下午1:58
 * @ClassName jian28
 * @Description 对称的二叉树
 */

public class jian28 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return verify(root, root);
        }

        boolean verify(TreeNode a,  TreeNode b){
            if( a == null && b == null) return  true;
            if(a == null || b == null) return false;
            if(a.val != b.val) return false;

            return verify(a.left, b.right) && verify(a.right, b.left);
        }
    }



    public void test(){
        TreeNode node = TreeNode.create(new Integer[]{1, 2, 2, null,3, null,3 });
        boolean r = new Solution().isSymmetric(node);
        System.out.println("r = " + r);
    }

    public static void main(String[] args) {
        new jian28().test();
    }
}

