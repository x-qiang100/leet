package Common;

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

    public static void show(TreeNode root){
        pre(root );
    }

    static void pre(TreeNode node){
        if(node == null){
            return;
        }
        pre(node.left);
        System.out.print(node.val+" ");
        pre(node.right);

    }


    public static void main(String[] args) {
        TreeNode treeNode = create(new Integer[]{
//                1, 2, 3, 4, 5, 6, 7
                3,9,20,null,null,15,7
        });
        show(treeNode );

    }


}

