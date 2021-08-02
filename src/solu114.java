import Common.TreeNode;

import java.util.Stack;

/**
 * @author xq
 * @Date 2021/8/2 下午8:34
 * @ClassName solu114
 * @Description 二叉树展开为链表
 */

public class solu114 {
    class Solution {
        public void flatten(TreeNode root) {
            TreeNode p = root;
            if(p == null){
                return;
            }
            TreeNode tem ;
            while (p != null && p.left == null){
                p = p.right;
            }
            while (p!=null ){
                tem = p.right;
                p.right = p.left;
                p.left = null;

                TreeNode t = p;
                while (t.right != null){
                    t = t.right;
                }
                t.right = tem;

                while (p != null && p.left == null){
                    t = p;
                    p = p.right;
                }

                if(p == null){
                    break;
                }
            }



        }
    }

    public void flatten(TreeNode root) {
        new Solution().flatten(root );
        TreeNode.show(root);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(new Integer[]{
//                1,2,3,4,5,6,7
                1,2,5,3,4,null,6
//                1,5,2,null,null,3,null
        });
        new solu114().flatten(root);
    }

}

