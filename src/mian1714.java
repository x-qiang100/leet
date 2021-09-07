import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xq
 * @Date 2021/9/3 下午7:59
 * @ClassName mian1714
 * @Description 面试题17.14 最小k个数
 */

public class mian1714 {

    class Solution {
        public int[] smallestK(int[] arr, int k) {
            Queue<Integer> queue = new PriorityQueue<>(
                    (o1, o2) -> o2 - o1
            );
            int length = arr.length;
            int size = 0;
            for (int i = 0; i < length; i++) {
                queue.offer(arr[i]);
                if(size >= k){
                    queue.poll();
                }
                size++;
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll();
            }
            return ans;
        }
    }

    public int[] smallestK(int[] arr, int k) {

        int[] ints = new Solution().smallestK(arr, k);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        return ints;
    }

    public static void main(String[] args) {
        int[] arr = {
                2,1,3,3,4,45,2,6
        } ;
        new mian1714().smallestK(arr, 4);
    }

}

