package jz;

/**
 * @author xq
 * @Date 2021/9/13 下午5:09
 * @ClassName jian10_1
 * @Description 斐波那切数列
 */

public class jian10_1 {
    class Solution {
        public int fib(int n) {
            int[] nums = new int[120];
            nums[2] = 2;
            nums[1] = 1;
            for (int i = 3; i <= n; i++) {
                nums[i] = nums[i - 1] + nums[ i - 2];
                nums[i] = nums[i]%(int)(1e9+7);
            }
            return nums[n];
        }
    }

    public void test(){
        int fib = new Solution().fib(7);
        System.out.println("fib = " + fib);
    }

    public static void main(String[] args) {
        new jian10_1().test();
    }

}

