/**
 * @author xq
 * @Date 2021/8/3 上午8:39
 * @ClassName solu581
 * @Description 最短无序连续子数组
 * 无序子数组最小元素正确位置可以确定左边界，
 * 无序子数组最大元素正确位置可以确定右边界，
 *
 */

public class solu581 {

    class Solution1 {
        public int findUnsortedSubarray(int[] nums) {

            int l = nums.length;
            int max = nums[0];

            int start = -1;
            int end = -2;
            for (int i = 0; i < l; i++) {
                if(nums[i] < max){
                    end = i;
                }
                if(nums[i] > max){
                    max = nums[i];
                }
            }
            int min = nums[l - 1];
            for (int i = l - 1 ; i >= 0; i--) {
                if(nums[i] > min){
                    start = i;
                }
                min = Math.min(min, nums[i]);
            }
            return end-start+1;
        }
    }



    public int findUnsortedSubarray(int[] nums) {
        int unsortedSubarray = new Solution1().findUnsortedSubarray(nums);
        return unsortedSubarray;
    }
    public static void main(String[] args) {
        int[] ints = new int[]{
//                6,4,8,10,9,15,2,6,4,8,10,9,15,7
//                  2,3,3,2,4
                1,2,4,5,4,6
//                5,12,3,8
//                1,2,3,4
        };
        new solu581().findUnsortedSubarray(ints);
    }

}

