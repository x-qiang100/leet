/**
 * @author xq
 * @Date 2021/8/2 下午5:31
 * @ClassName solu96
 * @Description 不同的二叉搜索树
 */

public class solu96 {
    class Solution {
        public int numTrees(int n) {
            int[] ints = new int[20];
            ints[0] = 1;
            ints[1] = 1;
            ints[2] = 2;
            for (int i = 3; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= i; j++) {
                    sum+=ints[j-1]*ints[i-j];
                }
                ints[i] = sum;
            }
            return ints[n];
        }
    }
    public int numTrees(int n) {
        return new Solution().numTrees(n);
    }

    public static void main(String[] args) {
        new solu96().numTrees(18);
    }



}

