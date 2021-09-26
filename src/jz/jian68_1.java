package jz;

import Common.TreeNode;

/**
 * @author:xq
 * @date:2021/9/24 13:44
 * ClassName:jian68_1
 * Package:jz
 * Description:
 */
public class jian68_1 {

    class Solution {
        TreeNode p1;
        TreeNode q1;
        boolean ansBo = false;
        TreeNode ans = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(p1.val < q1.val){
                p1 = p;
                q1 = q;
            }else {
                p1 = q;
                q1 = p;
            }

            def(root);
            return null;
        }

        boolean def(TreeNode root ){
            if(root ==  null) return false;
            boolean b = false;
            if(root == p1 || root == q1){
                b = true;
            }
            boolean b1 = false;
            boolean b2 = false;
            if(root.val > p1.val){
                b1 = def(root.left);
            }
            if(root.val < q1.val){
                b2 = def(root.right);
            }

            if(b1 && b2 && ans== null){
                ans = root;
            }
            if((b1||b2) && b && ans== null){
                ans = root;
            }
            return b || b1 || b2;
        }
    }

    public static void main(String[] args) {
    }


}
