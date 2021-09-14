package dp;

/**
 * @author xq
 * @Date 2021/9/12 下午2:43
 * @ClassName solu53
 * @Description 最大子序和
 */

public class solu53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = 0;
            int maxAns = nums[0];
            for (int num : nums) {
                max = Math.max(max+num, num);
                maxAns = Math.max(maxAns,max);
            }
            return maxAns;
        }
    }
}

