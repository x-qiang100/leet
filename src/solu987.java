import Common.TreeNode;

import java.util.*;

/**
 * @author xq
 * @Date 2021/7/31 上午9:18
 * @ClassName solu987
 * @Description 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。
 * 树的根结点位于 (0, 0) 。  二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，
 * 形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 */

public class solu987 {
    //首先便利所有节点，记录下他们的行号row和列号col以及值val，根据col为第一关键字升序，row为第二关键字升序，val为第三关键字升序。
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int min = 0;
        int max = -1;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            pre(root, 0, 0);
            for (int i = min; i <= max; i++) {
                List<int[] > t = map.get(i);
                t.sort((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return (o1[0] > o2[0]) ? 1 : -1;
                    }
                    return (o1[1] > o2[1]) ? 1 : -1;
                });
                List<Integer> l = new ArrayList<>();
                for (int[] ints : t) {
                    l.add(ints[0] );
                }
                ans.add(l);
            }
            return ans;
        }

        //k表示左右次序，d表示上下次序
        void pre(TreeNode node, int k, int d){
            if(node == null){
                return;
            }
            if(k < min){
                min = k;
            }
            if(k > max){
                max = k;
            }

            pre(node.left, k-1, d+1);

            List<int[] > list = map.getOrDefault(k, new ArrayList<>() );
            list.add(new int[]{node.val, d} );
            map.put(k, list);

            pre(node.right, k+1, d+1);
        }


    }

    class Solution3 {
        public LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<>(1001);
        public ArrayList<int[]> list = new ArrayList<>();
        public ArrayList<int[]> verticalTraversal(TreeNode root) {
            //      setIndex(root,0);
            for(int i=-200;i<200;++i){

                ArrayList<Integer> nums = map.get(i);
                if(nums!=null){
                    nums.sort((o1, o2) -> o1-o2);
                    int len = nums.size();
                    int[] num = new int[len];
                    for(int j = 0;j<len;++j){
                        num[j] = nums.get(j);
                    }
                    list.add(num);
                }
            }
            System.out.println(list);
            return list;
        }

        public void setIndex(TreeNode root,int index){
            if(root == null){
                return ;
            }
            ArrayList<Integer> list = map.get(index);
            if(list == null) {
                list = new ArrayList<>();
                map.put(index,list);
            }
            list.add(Integer.valueOf(root.val));
            setIndex(root.left,index-1);
            setIndex(root.right,index+1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.verticalTraversal(root);
        System.out.println("lists = " + lists);

        return lists;
    }
        public static void main(String[] args) {
            solu987 solu987 = new solu987();
            TreeNode treeNode = TreeNode.create(new Integer[]{
//                    1, 2, 3, 4, 6, 5, 7
//                    3,9,20,null,null,15,7
                    3,1,4,0,2,2
            });
            solu987.verticalTraversal(treeNode );
        }
}

