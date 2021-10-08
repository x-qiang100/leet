package jz;

import Common.TreeNode;

import java.util.*;

/**
 * @author:xq
 * @date:2021/10/8 15:40
 * ClassName:jian37
 * Package:jz
 * Description:
 */
public class jian37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
//            sb.append('[');
            queue.add(root);
            while (queue.size() != 0){
                TreeNode va = queue.poll();
                if(va != null ){
                    queue.add(va.left );
                    queue.add(va.right);
                    sb.append(va.val);
                }else {
                    sb.append("null");
                }
                sb.append(',');
            }

//            sb.replace(sb.length()-1 , sb.length(), "]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            if(split.length == 0 || split[0].equals("")) return null;
//            System.out.println("split[0] = " + "-"+split[0]+"-");
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));

            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            int idx = 0;
            for (String s : split) {
                while (list.get((idx-1)/2) == null){
                    idx++;
                }
                if(!s.equals("null") && idx != 0){
                    TreeNode treeNode = new TreeNode(Integer.parseInt(s));
                    if(idx % 2 ==1){
                        list.get((idx-1)/2 ).left = treeNode;
                    }else {
                        list.get((idx-1)/2 ).right = treeNode;
                    }
                    list.add(treeNode);
                }
                if(s.equals("null")){
                    list.add(null );
                }
                idx++;
            }
            return root;
        }

    }

    void test(){
        TreeNode treeNode = TreeNode.create(new Integer[]{
//                1,2,3,null,null,4,5,null,null,null,null,6,null,7,null
//                5,4,7,3,null,2,null,-1,null,null,null,9,null,null,null
        });
        TreeNode.show(treeNode);

        final Codec codec = new Codec();
        final String s = codec.serialize(treeNode);
        System.out.println("s = " + s);
        final TreeNode deserialize = codec.deserialize(s);
        TreeNode.show(deserialize);
    }
    public static void main(String[] args) {
        new jian37().test();
    }


}
