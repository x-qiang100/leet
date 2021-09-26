package jz;

import Common.TreeNode;

/**
 * @author:xq
 * @date:2021/9/25 20:51
 * ClassName:jian07
 * Package:jz
 * Description: 重建二叉树
 */
public class jian07 {

    class Solution {

        int[] pre ;
        int[] io ;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            pre = preorder;
            io = inorder;
            return div(0,preorder.length, 0, inorder.length);
        }

        TreeNode div(int preLeft, int preRight, int inLeft, int inRight){
            if(preLeft >= preRight){
                return null;
            }
            TreeNode treeNode = new TreeNode(pre[preLeft] );
            int idx = -1;
            for (int i = inLeft; i < inRight; i++) {
                if(pre[preLeft] == io[i]){
                    idx = i;
                }
            }
            int le = idx-inLeft+preLeft+1;
            TreeNode left  = div(preLeft+1, le , inLeft, idx);
            TreeNode right = div(le, preRight,idx+1, inRight);
            treeNode.left = left;
            treeNode.right = right;
            return treeNode;
        }
    }

    public static void main(String[] args) {

    }
}
