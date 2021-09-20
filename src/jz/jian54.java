package jz;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/20 14:11
 * ClassName:jian54
 * Package:jz
 * Description:
 */
public class jian54 {

    class Solution {
        int ans;
        int idx;
        public int kthLargest(TreeNode root, int k) {
            dfs(root);
            idx = k;
            return ans;
        }
        void dfs(TreeNode root){
            if(root == null) return;
            dfs(root.right);
            if(idx == 0){ ans = root.val; }
            idx--;
            dfs(root.left);
        }
    }

    void test(){
        final TreeNode treeNode = TreeNode.create(new Integer[]{
                3, 1, 4, null, 2
        });
        final int i = new Solution().kthLargest(treeNode, 1);
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        new jian54().test();
    }
}
