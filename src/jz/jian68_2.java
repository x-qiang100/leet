package jz;

import Common.TreeNode;

/**
 * @author:xq
 * @date:2021/9/25 20:36
 * ClassName:jian68_2
 * Package:jz
 * Description:
 */
public class jian68_2 {
    class Solution {
        TreeNode p1;
        TreeNode q1;
        boolean ansBo = false;
        TreeNode ans = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            p1 = p;
            q1 = q;
            def(root);
            return ans;
        }

        boolean def(TreeNode root ){
            if(root ==  null) return false;
            boolean b = false;
            if(root == p1 || root == q1){
                b = true;
            }
            boolean b1 = def(root.left);
            boolean b2 = def(root.right);

            if(b1 && b2 && ans== null){
                ans = root;
            }
            if((b1||b2) && b && ans== null){
                ans = root;
            }
            return b || b1 || b2;
        }
    }

}
