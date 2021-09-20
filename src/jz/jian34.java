package jz;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/20 13:33
 * ClassName:jian34
 * Package:jz
 * Description:
 */
public class jian34 {
    class Solution {

        List<List<Integer>> lists ;
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            lists = new ArrayList<>();
            dfs(root, target, new ArrayList<>());
            return lists;
        }

        void dfs(TreeNode root, int tar, List<Integer> list){
            if(root == null) return;
            tar-=root.val;
            list.add(root.val);
            if(tar == 0 && root.left == null && root.right == null){
                lists.add(new ArrayList<>(list) );
            }
            dfs(root.left, tar, list);
            dfs(root.right, tar, list);
            list.remove(list.size()-1 );
        }

    }

    void  test(){
        final TreeNode treeNode = TreeNode.create(new Integer[]{
                5, 4, 8, 11, null, 13, 4, 7, 2,null, null, null, null, 5, 1
//                1,2
        });
        TreeNode.show(treeNode);
        TreeNode.showInorder(treeNode);
        TreeNode.showPostorder(treeNode);
        final List<List<Integer>> lists = new Solution().pathSum(treeNode, 1);
        System.out.println("lists = " + lists);
//        new
    }
    public static void main(String[] args) {
        new jian34().test();
    }

}
