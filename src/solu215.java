import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xq
 * @Date 2021/8/10 下午3:56
 * @ClassName solu215
 * @Description 数组中的第K个最大元素
 */

public class solu215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pri = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pri.add(nums[i]);
            }
            int l = nums.length;
            for (int i = k; i < l; i++) {
                if(pri.peek() != null && nums[i] > pri.peek()){
                    pri.poll();
                    pri.add(nums[i] );
                }
            }
            return pri.peek();
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int kthLargest = new Solution().findKthLargest(nums, k);
        System.out.println("kthLargest = " + kthLargest);
        return kthLargest;
    }

    public static void main(String[] args) {
        new solu215().findKthLargest(new int[]{
            2,3,4,5,6,8,1,7,8
        }, 2);
    }

}

