package jz;

/**
 * @author:xq
 * @date:2021/9/15 8:17
 * ClassName:jian46
 * Package:jz
 * Description:把数字翻译成字符串
 */
public class jian46 {
    class Solution {
        public int translateNum(int num) {
            if(num < 10) return 1;
            int temp = num;
            int length = 0;
            while (temp > 0){
                temp = temp/10;
                length++;
            }
            int[] nums = new int[length ];
            temp = num;
            while (temp > 0){
                int val = temp%10;
                temp = temp/10;
                length--;
                nums[length] = val;
            }
            length = nums.length;

            int[] ans = new int[length ];
            ans[0] = 1;

            ans[1] = 1;
            if(nums[0]*10 + nums[1] < 26){
                ans[1] = 2;
            }
            for (int i = 2; i < length; i++) {
                int s = nums[i-1]*10+nums[i];
                if(s < 26 && nums[i-1]!=0){
                    ans[i] = ans[i-1]+ans[i-2];
                }else
                {
                    ans[i] = ans[i-1];
                }
            }
            return ans[length-1];
        }
    }

    void test(){
        final int i = new Solution().translateNum(1020);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        int i = 1111111111;

        new jian46().test();
        /*
        1

        11
        1 1

        1 1 1
        1 11
        11 1

        1 1 1 1
        1 11 1
        11 1 1
        11 11
        1 1 11

5
5 5
5 5 5

         */
    }

}
