import Common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/10 下午8:00
 * @ClassName solu113
 * @Description 路径总和
 */

public class solu113 {
    class Solution {
        int target;
        List<List<Integer>> ans;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if(root == null) return null;
            this.target = targetSum;
            List<Integer> list = new LinkedList<>();
            ans = new ArrayList<>();
            list.add(root.val);
            int sum = 0;
            sum+=root.val;

            backtrack(root, sum, list);
            return ans;
        }

        void backtrack(TreeNode node, int sum, List<Integer> list){
            if(node.left == null && node.right == null){
                if(sum == target){
                    ans.add(new LinkedList<>(list));
                }
                return;
            }

            if(node.left != null){
                int value = node.left.val;
                sum+=value;
                list.add(value);
                backtrack(node.left,  sum, list);
                list.remove(list.size() - 1);
                sum-=value;
            }
            if(node.right != null){
                int value = node.right.val;
                sum+=value;
                list.add(value);
                backtrack(node.right, sum, list);
                list.remove(list.size() - 1);
                sum-=value;
            }
        }
    }
    //简化
    class Solution1 {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> path = new LinkedList<Integer>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            ans = new ArrayList<>();
            if(root == null) return ans;
            List<Integer> list = new LinkedList<>();
            backtrack(root, targetSum);
            return ans;
        }
        void backtrack(TreeNode node, int targetSum){
            if(node == null){
                return;
            }
            int value = node.val;
            targetSum-=node.val;
            path.offerLast(value );
            if(node.left == null && node.right == null && targetSum == 0){
                ans.add(new LinkedList<>(path) );
            }
            backtrack(node.left, targetSum);
            backtrack(node.right,targetSum );
            path.pollLast();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new Solution1().pathSum(root, targetSum);
        System.out.println("lists = " + lists);
        return lists;
    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{
                5,4,8,11,null,13,4,7,2,null,null,null,null,5,11,1
//                1,2,3
        });
        new solu113().pathSum(treeNode, 22);

    }


}

