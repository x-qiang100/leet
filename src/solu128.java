
import java.util.*;

/**
 * @author xq
 * @Date 2021/8/3 上午10:09
 * @ClassName solu128
 * @Description 最长连续数列
 */

public class solu128 {

    //并查集解法，维护一个map，存放它的值val的val+1，find寻找路径最大长度，若已经找过节点，跳过
    class Solution {

        Map<Integer, Integer> maps = new HashMap<>();
        public int longestConsecutive(int[] nums) {
            int l = nums.length;
            if(l == 0) return 0;

            for (int j : nums) {
                maps.put(j, j + 1);
            }
            int ans = 0;
            for (int num : nums) {
                if( maps.get(num-1) == null ) {
                    ans = Math.max(ans, find(num) - num);
                }
            }
            return ans;
        }

        int find(int n){
            Integer x = n;
            int ans = 0;
            while (x != null){
                ans = x;
                x = maps.get(x);
            }
            return ans;
        }
    }

    //哈希表
    class Solution1{}

    public int longestConsecutive(int[] nums) {
        int i = new Solution().longestConsecutive(nums);
        System.out.println("i = " + i);
        return i;
    }
    public static void main(String[] args) {
        int[] is = {
//                100,4,2,3,5
                0,3,7,2,8,4,6,0,1,5
        };
//        int l = 10000;
//        is= new int[l];
//        Random r = new Random(100);
//        for (int i = 0; i < l; i++) {
//            is[i] = r.nextInt(l);
//        }
        int i = new solu128().longestConsecutive(is );

    }
}

