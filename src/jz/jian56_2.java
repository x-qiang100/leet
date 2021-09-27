package jz;

/**
 * @author:xq
 * @date:2021/9/27 17:24
 * ClassName:jian56_2
 * Package:jz
 * Description:
 */
public class jian56_2 {

    class Solution {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for(int num : nums){
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }
}
