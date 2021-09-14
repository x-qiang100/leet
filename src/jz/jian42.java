package jz;

/**
 * @author xq
 * @Date 2021/9/14 下午5:04
 * @ClassName jian42
 * @Description 连续子数组的最大和
 */

public class jian42 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxTemp = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                maxTemp = Math.max(num, maxTemp+num);
                max = Math.max(max, maxTemp);
            }
            return max;
        }
    }

    public static void main(String[] args) {

    }
}

