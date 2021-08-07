/**
 * @author xq
 * @Date 2021/8/7 上午8:41
 * @ClassName slou457
 * @Description 环形数组是否存在环
 */

public class solu457 {

    //快慢指针
    class Solution {
        int l;
        public boolean circularArrayLoop(int[] nums) {
            l = nums.length;

            for (int i = 0; i < l; i++) {
                if(nums[i] == 0){
                    continue;
                }
                int slow = i;
                int fast = run(i, nums[i]);

                while (nums[slow] * nums[fast] > 0 &&nums[slow] *nums[run(fast, nums[fast])]>0 ){
                    if (slow == fast) {
                        if (slow != run(slow, nums[slow])) {
                            return true;
                        } else {
                            break;
                        }
                    }
                    slow = run(slow, nums[slow]);
                    fast = run(fast, nums[fast]);
                    fast = run(fast, nums[fast]);
                }
                int add = i;
                while (nums[add] * nums[run(add, nums[add])] > 0) {
                    int tmp = add;
                    add = run(add,nums[add]);
                    nums[tmp] = 0;
                }
            }
            return false;
        }
        private int run(int index, int step){
            int i = index + step;
            return i = (l + i%l)%l;
        }



    }


    public boolean circularArrayLoop(int[] nums) {
        boolean b = new Solution().circularArrayLoop(nums);
        System.out.println("b = " + b);
        return b;
    }
    public static void main(String[] args) {
        int[] ints = {
                -1,-2
        };
        new solu457().circularArrayLoop(ints);
    }

}

