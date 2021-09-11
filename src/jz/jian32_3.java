package jz;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/9/11 下午8:00
 * @ClassName jian32_1
 * @Description 从上到下打印二叉树
 */

public class jian32_3 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 0);
            return listList;
        }

        List<List<Integer>> listList = new ArrayList<>();
        void dfs(TreeNode node, int deep){
            if(node == null){ return; }
            List<Integer> list;
            if(listList.size() <= deep){
                 list = new ArrayList<>();
                 list.add(node.val);
                 listList.add(list);
            }else {
                 list = listList.get(deep);
                 list.add(node.val);
            }

            dfs(node.left, deep+1);
            dfs(node.right, deep+1);
        }

    }

    public void test(){
        TreeNode node = new TreeNode();
        node = TreeNode.newCreate(new Integer[]{3,9,20,null,null,15,7,3,null,8});
        TreeNode.show(node);
        TreeNode.showPostorder(node);
        List<List<Integer>> lists = new Solution().levelOrder(node);
        System.out.println("lists = " + lists);
    }

    public static void main(String[] args) {
        new jian32_3().test();
    }



}

