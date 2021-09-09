package jz;

/**
 * @author xq
 * @Date 2021/9/9 下午1:18
 * @ClassName jian53_2
 * @Description 0—n-1缺失的数字
 */

public class jian53_2 {
    //数学：求和公式 n*(n+1)/2

    //原地置换
    class Solution {
        public int missingNumber(int[] nums) {
            int l = nums.length;
            int temp ;
            int p = 0;
            while (p < l){
                temp = nums[p];
                if(p == temp || temp == l){
                    p++;
                }else {
                    nums[p] = nums[temp];
                    nums[temp] = temp;
                }
            }
            int ans = l;
            for (int i = 0; i < l; i++) {
                if (nums[i] == l){
                    ans = i;
                    break;
                }
            }
            return ans;
        }
    }

    public void test(){
        int[] nums = {0,1,2,3,8,7,6,5};
        int i = new Solution().missingNumber(nums);
        System.out.println("i = " + i);

    }
    public static void main(String[] args) {
        new jian53_2().test();
    }

}

