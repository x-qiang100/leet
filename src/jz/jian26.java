package jz;

import Common.TreeNode;

/**
 * @author xq
 * @Date 2021/9/12 下午1:09
 * @ClassName jian26
 * @Description 数的子结构
 */

public class jian26 {

    class Solution {

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return verify(A,B);
        }

        boolean verify(TreeNode a, TreeNode b){
            if(b == null) return true;
            if( a == null || a.val != b.val) {
                return false;
            }
            return verify(a.left, b.left) && verify(a.right, b.right);
        }
    }

    public void test(){
        TreeNode a = TreeNode.create(new Integer[]{3,4,5,1,2});
        TreeNode b = TreeNode.create(new Integer[]{4, 1});
        boolean subStructure = new Solution().isSubStructure(a, b);
        System.out.println("subStructure = " + subStructure);
    }
    public static void main(String[] args) {
        new jian26().test();
    }
}

