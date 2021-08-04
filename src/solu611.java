import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/4 上午8:41
 * @ClassName solu611
 * @Description 有效三角形的个数
 */

public class solu611 {
    class Solution {
        int[] all = new int[1001];
        public int triangleNumber(int[] nums) {
            int lAll = 1001;
            int lNums = nums.length;
            Arrays.sort(nums);
            for (int num : nums) {
                all[num]++;
            }
            //维护给定数组值的前缀和，便于寻找大小，也可以动态建立。
            for (int i = 1; i < 1001; i++) {
                all[i]+=all[i-1];
            }
            //
            int count = 0;
            for (int i = 0; i < lNums - 1 ; i++) {
                for (int j = i + 1; j < lNums; j++) {
                    if(nums[i] ==0 || nums[j] == 0){
                        continue;
                    }
                    int sideMax = nums[i]+nums[j] - 1;
                    int sideMin = nums[j];
                    if(sideMax > 1000){
                        sideMax = 1000;
                    }
                    int s = all[sideMax] - j - 1;
                    count+=s;
                }
            }
            return count;
        }
    }
    public int triangleNumber(int[] nums) {
        int i = new Solution().triangleNumber(nums);
        System.out.println("i = " + i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {
                995,510,194,695,973,240,512,846,163,874,531,80,117,714,227,618,717,243,638,496,725,917,748,990,440,172,723,260,507,606,863,602,138,93,115,756,97,238,94,343,602,788,199,305,657,243,560,199,274,343,310,849,148,236,848,382,995,421,822,607,306,42,722,73,787,488,7,484,822,281,400,389,64,750,59,678,86,62        };
        int i = new solu611().triangleNumber(nums );
    }

}

