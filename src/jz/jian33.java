package jz;

import java.util.Arrays;

/**
 * @author:xq
 * @date:2021/9/25 21:24
 * ClassName:jian33
 * Package:jz
 * Description: 二叉搜索树的后序遍历序列
 */
public class jian33 {
    class Solution {
        int[] num;
        public boolean verifyPostorder(int[] postorder) {
            num = postorder;
            return div(0, postorder.length);
        }

        boolean div(int left, int right){
            if(left +1 >= right) return true;

            for (int i = left; i < right; i++) {
                System.out.println("num[i] = " + num[i]);
            }
            System.out.println();
            int flag = num[right-1];
            //左右子树分界
            int idx = -1;
            for (int i = left; i < right; i++) {
                if(num[i] > flag){
                    idx = i;
                    break;
                }
            }
            if(idx == -1){
                idx = right-1;
            }
            for (int i = idx; i < right; i++) {
                if(num[i]<flag){
                   return false;
                }
            }
            boolean b1 = div(left, idx);
            boolean b2 = div(idx, right-1);
            return b1&&b2;
        }
    }

    void test(){
        final int[] ints = new int[]{
//                1,3,2,5
                1,4,2,6,8,7,10,9,5
//                1,3,2,6,5
//                1,2,5,10,6,9,4,3
        };
        final boolean b = new Solution().verifyPostorder(ints);
        System.out.println("b = " + b);
    }
    public static void main(String[] args) {
        new jian33().test();
    }


}
