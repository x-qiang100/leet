import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/11 上午10:59
 * @ClassName solu99
 * @Description 恢复二叉搜索树
 */

public class solu99 {

    class Solution {
        long value = Long.MIN_VALUE;
        TreeNode pre;
        TreeNode err1;
        TreeNode errPr;
        TreeNode err2;
        public void recoverTree(TreeNode root) {
            dfs(root);
            if (err2 == null) {
                if(err1 == null){
                    return;
                }
                err2 = err1;
            }
            System.out.println("err1 = " + err1);
            System.out.println("err2 = " + err2);
            System.out.println("errpr = " + errPr);
            int tmp = err2.val;
            err2.val = errPr.val;
            errPr.val = tmp;
        }
        void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);

            if (node.val <= value) {
                System.out.println(node.val);
                if (err1 != null) {
                    err2 = node;
                } else {
                    errPr = pre;
                    err1 = node;
                }
            }
            pre = node;
            value = node.val;

            dfs(node.right);
        }
    }


    public void recoverTree(TreeNode root) {
         new Solution().recoverTree(root);
         TreeNode.show(root);
    }
    public static void main(String[] args) {
     TreeNode n = TreeNode.newCreate(new Integer[]{
          1,null,4,6,2
//             5,2,null
     });
     TreeNode.show(n);
     TreeNode.showInorder(n);


//     new solu99().recoverTree(n);
    }
}

