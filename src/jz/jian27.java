package jz;

import Common.TreeNode;

/**
 * @author xq
 * @Date 2021/9/12 下午1:50
 * @ClassName jian27
 * @Description 二叉树的镜像
 */

public class jian27 {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            return copy(root);
        }
        TreeNode copy(TreeNode node){
            if(node == null) return null;
            TreeNode temp = new TreeNode(node.val);

            temp.left = copy(node.right);
            temp.right = copy(node.left);

            return temp;
        }
    }

    public void test(){
        TreeNode node = TreeNode.create(new Integer[]{14, 2, 7, 1, 3, 6, 9});
        TreeNode r = new Solution().mirrorTree(node);
        TreeNode.show(r);
    }

    public static void main(String[] args) {
        new jian27().test();
    }



}

