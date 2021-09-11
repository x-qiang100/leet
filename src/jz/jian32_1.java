package jz;

import Common.TreeNode;

import java.util.*;

/**
 * @author xq
 * @Date 2021/9/11 下午8:19
 * @ClassName jian32_1
 * @Description 从上到下打印出二叉树
 */

public class jian32_1 {

    class Solution {
        public int[] levelOrder(TreeNode root) {
            List<Integer> bfs = bfs(root);
            int[] ans = new int[bfs.size()];
            for (int i = 0; i < bfs.size(); i++) {
                ans[i] = bfs.get(i);
            }
            return ans;
        }
        List<Integer> bfs(TreeNode node){
            if(node == null) return new ArrayList<Integer>();

            Queue<TreeNode> queue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            queue.add(node);
            TreeNode temp = node;
            TreeNode nextTemp = node;
            while ( !queue.isEmpty()){
                while (!queue.isEmpty()){
                    TreeNode poll = queue.poll();
                    list.add(poll.val );
                    if(poll.left != null){ queue.add(poll.left);nextTemp = poll.left; }
                    if(poll.right != null){ queue.add(poll.right); nextTemp = poll.right;}
                    if(poll == temp){
                        break;
                    }
                }
                temp = nextTemp;
            }
            return list;
        }
    }

    public void test(){
        TreeNode node = new TreeNode();
        node = TreeNode.newCreate(new Integer[]{3,9,20,null,null,15,7,3,null,8});
        TreeNode.show(node);
        TreeNode.showPostorder(node);
        int[] ints = new Solution().levelOrder(node);
        System.out.println("lists = " + Arrays.toString(ints).toString());
    }

    public static void main(String[] args) {
        new jian32_1().test();
    }

}

