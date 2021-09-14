package dp;

import Common.TreeNode;

/**
 * @author xq
 * @Date 2021/9/12 下午2:51
 * @ClassName solu121
 * @Description 股票的最大时机
 */

public class solu121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int va = 0;
            for (int price : prices) {
                min = Math.min(min, price);
                va = Math.max(va, price - min);
            }
            return va;
        }
    }

    public void test(){
        int i = new Solution().maxProfit(new int[]{7, 1, 5, 3, 2, 10});
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        new solu121().test();
    }
}

