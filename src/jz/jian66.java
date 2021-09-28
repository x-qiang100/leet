package jz;

import Common.TreeNode;

import java.util.Arrays;

/**
 * @author:xq
 * @date:2021/9/28 14:11
 * ClassName:jian66
 * Package:jz
 * Description:
 */
public class jian66 {
    class Solution {
        public int[] constructArr(int[] a) {
            if(a == null ||a.length == 0) return new int[]{};
            int l = a.length;
            int[] ans = new int[l];
            int pre[] = new int[l];
            int post[] = new int[l];
            pre[0] = a[0];
            post[l-1] = a[l-1];
            for (int i = 1; i < l; i++) {
                pre[i] = pre[i-1]*a[i];
                post[l-1-i] = post[l-i]*a[l-i-1];
            }
            ans[0] = post[1];
            ans[l-1] = pre[l-2];
            for (int i = 1; i < l-1; i++) {
                ans[i] = pre[i-1]*post[i+1];
            }
            System.out.println("Arrays.toString(pre) = " + Arrays.toString(pre));
            System.out.println("Arrays.toString(pre) = " + Arrays.toString(post));
            return ans;
        }
    }
}
