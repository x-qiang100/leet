import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xq
 * @Date 2021/8/11 上午8:42
 * @ClassName solu446
 * @Description 等差数列划分2-子序列
 */

public class solu446 {

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int ans = 0;
            int l = nums.length;
            Map<Long, Integer>[] maps = new Map[l];
            for (int i = 0; i < l; i++) {
                maps[i] = new HashMap<Long, Integer>();
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < i; j++) {
                    long dif = (long) nums[i] - nums[j];
                    int cnt = maps[j].getOrDefault(dif, 0);
                    ans += cnt;
                    maps[i].put(dif,maps[i].getOrDefault(dif, 0)+cnt+1);
                }
            }
//            System.out.println("Arrays.toString(maps) = " + Arrays.toString(maps));
            return ans;
        }
    }



    public int numberOfArithmeticSlices(int[] nums) {
        int i = new Solution().numberOfArithmeticSlices(nums);
        System.out.println("i = " + i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        new solu446().numberOfArithmeticSlices(nums);
    }
}

