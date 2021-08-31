import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/10 上午8:39
 * @ClassName solu413
 * @Description 等差数列
 */

public class solu413 {
    //遍历
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int l = nums.length;
            if(l <= 2) return 0;

            int sum = 0;
            int pre = 0;

            for (int i = 0; i < l - 2; i++) {
                int dif = nums[i + 1] - nums[i];

                int j = i+1;
                while (j < l - 1){
                    if(nums[j+1] - nums[j] == dif){
                        pre++;
                    }else {
                        break;
                    }
                    j++;
                }
                sum+=pre;

                while (pre > 0){
                    pre--;
                    i++;
                    sum+=pre;
                }
//                if(pre > 0){
//                    i++;
//                    i++;
//                }
            }
//            System.out.println("Arrays.toString(count) = " + Arrays.toString(count));
//            for (int i : count) {
//                sum+=i;
//            }
            return sum;
        }
    }
    public int numberOfArithmeticSlices(int[] nums) {

        int i = new Solution().numberOfArithmeticSlices(nums);
        System.out.println("i = " + i);
        return i;
    }

    public static void main(String[] args) {
        int[] n = {
                1,3,5,7,9
        };
        new solu413().numberOfArithmeticSlices(n );
    }


}

