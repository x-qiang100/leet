package jz;

/**
 * @author xq
 * @Date 2021/9/9 下午12:35
 * @ClassName jian03
 * @Description 数组重复数字
 */

//原地交换
public class jian03 {
    //空间复杂度 O(1)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            int l = nums.length;
            int temp = -1;
            int p = 0;
            while (p < l){
                temp = nums[p];
                if(p == temp){
                    p++;

                } else if (temp == nums[temp]){
                    break;
                }else {
                    nums[p] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return temp;
        }
    }

    public void test(){
        int repeatNumber = new Solution().findRepeatNumber(new int[]{3, 4, 2, 0, 0, 1});
        System.out.println("repeatNumber = " + repeatNumber);
    }

    public static void main(String[] args) {
        new jian03().test();
    }

}

