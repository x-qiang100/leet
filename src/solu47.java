import java.util.*;

/**
 * @author xq
 * @Date 2021/8/10 下午9:20
 * @ClassName solu47
 * @Description 全排列
 */

public class solu47 {
    class Solution {
        List<List<Integer>> ans;
        List<Integer> out;
        boolean[] bo;
        int n;
        int[] ints;
        public List<List<Integer>> permuteUnique(int[] nums) {

            Arrays.sort(nums );
            ints = nums;
            ans = new ArrayList<>();
            out = new ArrayList<>();

            n = nums.length;
            bo = new boolean[n];
            backtrack(0);

            return ans;
        }
        void backtrack(int first){
            if(first == n){
                ans.add(new ArrayList<>(out));
                return;
            }
            for (int i = 0; i < n; i++) {
                if(bo[i] ||(i > 0 && ints[i] == ints[i-1] && !bo[i-1])){

                }else {
                    bo[i] = true;
                    out.add(ints[i]);
                    backtrack(first+1);
                    out.remove(first);
                    bo[i] = false;
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> lists = new Solution().permuteUnique(nums);
        System.out.println("lists = " + lists);
        System.out.println("lists.size() = " + lists.size());
        return lists;
    }

    public static void main(String[] args) {
        int[] ints = {
          1,1,2,2
        };

        new solu47().permuteUnique(ints );
    }
}
/*


 */