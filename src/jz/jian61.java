package jz;

import java.util.Arrays;

/**
 * @author:xq
 * @date:2021/9/21 12:53
 * ClassName:jian61
 * Package:jz
 * Description:
 */
public class jian61 {
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums );
            if(nums[3] == 0){ return true; }
            if(nums[2] == 0){
                int tem = nums[4] - nums[3];
                return tem != 0 && tem < 5;
            }
            if(nums[1] == 0){
                int t1 = nums[3]  - nums[2];
                int t2 = nums[4]  - nums[3];
                if(t1 == 0 || t2 == 0) return false;
                return t1 + t2 < 5;
            }
            if(nums[0] == 0){
                int t1 = nums[3]  - nums[2];
                int t2 = nums[4]  - nums[3];
                int t3 = nums[2]  - nums[1];
                if(t1 == 0 || t2 == 0 || t3 == 0 ) return false;
                return t1+t2+t3<5;
            }
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] - nums[i-1] != 1){
                    return false;
                }
            }
            return true;
        }
    }
}
