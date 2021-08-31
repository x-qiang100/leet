import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/11 下午4:45
 * @ClassName solu199
 * @Description 二叉树的右视图
 */

public class solu199 {
    class Solution {
        List<Integer> ans;
        public List<Integer> rightSideView(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);
            return ans;
        }

        void dfs(TreeNode root, int i){
            if(root == null){
                return;
            }
            if(ans.size() == i){
                ans.add(root.val );
            }
            dfs(root.right, i+1);
            dfs(root.left,  i+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new Solution().rightSideView(root);
        System.out.println("list = " + list);
        return list;
    }

    public static void main(String[] args) {
        Integer[] n = {
//                5,4,8,11,null,13,4,7,2,null,null,
                1,2,3,null,5,null,4
        } ;

        new solu199().rightSideView(TreeNode.newCreate(n));
    }

}

