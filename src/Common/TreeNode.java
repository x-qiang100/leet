package Common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @Date 2021/7/31 上午9:13
 * @ClassName TreeNode
 * @Description 二叉树的节点
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode create(Integer[] nums){
        int l = nums.length;
        TreeNode root = new TreeNode( );
        if(l == 0){
            return null;
        }
        root.val = nums[0];
        TreeNode[] trees = new TreeNode[l];
        trees[0] = root;
        for (int i = 1; i < l; i++) {
            if(nums[i] != null){
                TreeNode node = new TreeNode(nums[i]);
                trees[i] = node;
                if(i%2 == 1){
                    trees[(i - 1)/2].left = node;
                }else {
                    trees[(i - 1)/2].right = node;
                }
            }
        }
        return root;
    }

    public static TreeNode newCreate(Integer[] nums){
        TreeNode root = new TreeNode();
        int l = nums.length;
        if( l == 0 || nums[0]==null) return null;
        //initialize heap
        List<TreeNode> list = new ArrayList<>();
        list.add(null);
        root.val = nums[0];
        list.add(root);

        int idx = 2;
        for (int i = 1; i < l; i++) {
            //stop null error at the end of array
            int flag = idx;
            while (list.get(idx/2) == null){
                if(idx/flag == 2){
                    return root;
                }
                list.add(null);
                list.add(null);
                idx++;
                idx++;
            }

            TreeNode node = null;
            if(nums[i] != null){
                node = new TreeNode(nums[i]);
            }
            list.add(node);
            if(idx%2 == 0){
                list.get(idx/2).left =node;
            }else {
                list.get(idx/2).right = node;
            }
            idx++;
        }
        return root;
    }

    public static void show(TreeNode root){
        System.out.println("先序：");
        showPre(root);
        System.out.println("中序：");
        showInorder(root);
        System.out.println("后序：");
        showPostorder(root);
    }


    /**
     * 先序
     * @param root
     */
    public static void showPre(TreeNode root){
        pre(root );
        System.out.println();
    }
    static void pre(TreeNode node){
        if(node == null){ return; }
        System.out.print(node.val+" ");
        pre(node.left);
        pre(node.right);
    }


    /**
     * 中序
     * @param root
     */
    public static void showInorder(TreeNode root){
        Inorder(root );
        System.out.println();
    }
    static void Inorder(TreeNode node){
        if(node == null){ return; }
        Inorder(node.left);
        System.out.print(node.val+" ");
        Inorder(node.right);
    }


    /**
     * 后序
     * @param root
     */
    public static void showPostorder(TreeNode root){
        Postorder(root );
        System.out.println();
    }
    static void Postorder(TreeNode node){
        if(node == null){ return; }
        Postorder(node.left);
        Postorder(node.right);
        System.out.print(node.val+" ");
    }


}

