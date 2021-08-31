import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/11 下午4:24
 * @ClassName solu129
 * @Description 求根节点到叶节点数字之和
 */

public class solu129 {

    class Solution {
        int ans;
        public int sumNumbers(TreeNode root) {
            ans = 0;
            dfs(root, 0);
            return ans;
        }

        void dfs(TreeNode root, int m){
            if(root == null){
                return;
            }

            m = m*10+root.val;
            if(root.left == null && root.right == null){
                ans+=m;
            }
            dfs(root.left,  m);
            dfs(root.right, m);
        }
    }

    public int sumNumbers(TreeNode root) {
        int i = new Solution().sumNumbers(root);
        System.out.println("i = " + i);
        return i;
    }
    public static void main(String[] args) {
        Integer[] integers = {
                1,2,3
//                5,4,8,1,null,3,4,7,2,null,null,5,1
        };
        TreeNode node = TreeNode.newCreate(integers );
        new solu129().sumNumbers(node );
    }
}

