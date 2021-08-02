import Common.TreeNode;

import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/2 下午8:01
 * @ClassName solu105
 * @Description 从前序与中序遍历二叉树
 */

public class solu105 {

    //递归，但是可以加哈希表进行映射，加快查找根节点速度
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(preorder, inorder);
        }

        TreeNode dfs(int[] pre, int[] in){
            if(pre.length == 0){
                return null;
            }
            int value = pre[0];
            TreeNode node = new TreeNode(value);
            int p1 = 0;
            int i2 = 0;
            int l = in.length;
            for (int i = 0; i < l; i++) {
                if(in[i] == value) {
                    i2 = i;
                }
            }
            int p2 = (i2 - 0) + 1;

            TreeNode left = dfs(Arrays.copyOfRange(pre, 1, p2), Arrays.copyOfRange(in, 0, i2));
            TreeNode right = dfs(Arrays.copyOfRange(pre, p2, l), Arrays.copyOfRange(in, i2+1, l));
            node.left = left;
            node.right = right;
            return node;
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = new Solution().buildTree(preorder, inorder);
        TreeNode.show(node );
        return node;
    }

    public static void main(String[] args) {
        solu105 s = new solu105();
        int[] i1 = {3, 9, 20, 15, 7};
        int[] i2 = {9, 3, 15, 20, 7};
        int[] i3 = { 7};
        int[] i4 = { 7};
        s.buildTree(i3, i4);

    }


}

