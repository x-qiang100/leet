import java.util.HashMap;
import java.util.Map;

/**
 * @author xq
 * @Date 2021/8/6 上午9:20
 * @ClassName solu560
 * @Description 和为k的子数组
 */

public class solu560 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int l = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int pre = 0;
            map.put(0,1);
            for (int i = 1; i <= l; i++) {
                pre+=nums[i -1 ];
                count+=map.getOrDefault(pre - k, 0);

                map.put(pre, map.getOrDefault(pre, 0)+1);
                System.out.println("count = " + count);
            }

            return count;
        }
    }

    public int subarraySum(int[] nums, int k) {

        int i = new Solution().subarraySum(nums, k);
        System.out.println("i = " + i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,1,1,0
        };
        int k = 2;
        new solu560().subarraySum(nums, k);
    }
}

