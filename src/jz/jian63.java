package jz;

/**
 * @author xq
 * @Date 2021/9/13 下午5:11
 * @ClassName jian63
 * @Description 股票的最大利润
 */

public class jian63 {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0)return 0;
            int min = prices[0];
            int va = 0;
            for (int price : prices) {
                min = Math.min(min, price);
                va = Math.max(va, price - min);
            }
            return va;
        }
    }
}

