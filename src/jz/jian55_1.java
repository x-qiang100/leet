package jz;

import Common.TreeNode;

/**
 * @author:xq
 * @date:2021/9/21 15:07
 * ClassName:jian55_1
 * Package:jz
 * Description:
 */
public class jian55_1 {
    public static void main(String[] args) {
        class Solution {
            int deep;
            public int maxDepth(TreeNode root) {
                de(root, 0);
                return deep;
            }
            void de(TreeNode node, int d){
                if(node == null) {
                    if(deep > d){
                        deep = d;
                    }
                    return;
                }
                de(node.left, d+1);
                de(node.right, d+1);
            }
        }
    }
}
