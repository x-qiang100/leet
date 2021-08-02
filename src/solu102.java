import Common.TreeNode;

import java.util.*;

/**
 * @author xq
 * @Date 2021/8/2 下午7:22
 * @ClassName solu102
 * @Description 二叉树的层序遍历
 */

public class solu102 {

    //超出内存限制
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            list.add(root );
            int i = 2;
            int f = 0;
            while (true){
                if(list.get(i/2) != null) {
                    if (i % 2 == 0) {
                        list.add(list.get(i / 2).left);
                    } else {
                        list.add(list.get(i / 2).right);
                    }
                    f = i;
                }else {
                    list.add(null);
                }
                i++;
                if(i >= 2*f+2){
                    break;
                }
            }
            f = 1;
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            for (int j = 1; j < list.size(); j++) {
                if(list.get(j) != null){
                    l1.add(list.get(j).val);
                }
                if(j+1 == 2*f){
                    f*=2;
                    if(l1.size() != 0){
                        lists.add(new ArrayList<>(l1));
                    }
                    l1.clear();
                }
            }
            return lists;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if(root == null){
                return lists;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root );
            while (!queue.isEmpty() ){
                List<Integer> list = new ArrayList<>();
                int n = queue.size();
                for (int i = 0; i < n; ++i) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                lists.add(list);
            }
            return lists;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println("lists = " + lists);
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(
                new Integer[]{
//                        3, 9, 20, null, null, 15, 7
//                        1,null,2,null,null,null,3

                }
        );
        new solu102().levelOrder(treeNode);
    }
}

