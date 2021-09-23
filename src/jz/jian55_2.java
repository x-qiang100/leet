package jz;

import Common.TreeNode;

/**
 * @author:xq
 * @date:2021/9/23 13:46
 * ClassName:jian55_2
 * Package:jz
 * Description:
 */
public class jian55_2 {
    class Solution {
        boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            deep(root);

            return flag;
        }

        int deep(TreeNode root){
            if(root == null) return 0;

            int de1 = deep(root.left);
            int de2 = deep(root.right);


            if( de1-de2 > 1 || de2-de1 > 1){
                flag = false;
            }
            return Math.max(de1, de2)+1;
        }
    }


    void test(){
        final TreeNode treeNode = TreeNode.create(new Integer[]{
//3,9,20,null, null, 15,7
                1,2,2,3,3,null,null,4,4
        });
        final boolean balanced = new Solution().isBalanced(treeNode);
        System.out.println("balanced = " + balanced);
    }
    public static void main(String[] args) {
        new jian55_2().test();
    }
}
