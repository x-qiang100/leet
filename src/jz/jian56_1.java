package jz;

/**
 * @author:xq
 * @date:2021/9/27 13:21
 * ClassName:jian56_1
 * Package:jz
 * Description:
 */
public class jian56_1 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            final int l = nums.length;
            int res = 0;
            for (int value : nums) {
                res ^= value;
            }
            int tar = 1;
            while ((tar & res) == 0){
                tar = tar<<1;
            }
            int a = 0, b = 0;
            for (int num : nums) {
                if((num&tar) == 0){
                    a^=num;
                }else {
                    b^=num;
                }
            }
            return new int[]{a,b};
        }
    }

}
