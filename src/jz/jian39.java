package jz;

/**
 * @author:xq
 * @date:2021/9/28 14:09
 * ClassName:jian39
 * Package:jz
 * Description:
 */
public class jian39 {

    class Solution {
        public int majorityElement(int[] nums) {
            int vns = 0;
            int x = 0;
            for (int num : nums) {
                if(vns == 0) x = num;
                vns+=(num==x?1:-1);
            }
            return x;
        }
    }
}
