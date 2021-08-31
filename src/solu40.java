import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/13 上午10:40
 * @ClassName solu40
 * @Description 组合总数
 */

public class solu40 {

    class Solution {
        List<List<Integer>> ans;
        List<Integer> list;
        int[] nums;
        boolean[] val;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ans = new ArrayList<>();
            list = new ArrayList<>();

            Arrays.sort(candidates);
            nums = candidates;

            backtrack(0, target);
            return ans;
        }

        void backtrack(int idx, int target){
            if(target <= 0){
                if(target == 0){
                    ans.add(new ArrayList<>(list));
                }
                return;
            }

            if(idx == nums.length) return;

            for (int i = idx; i < nums.length; i++) {
                if(i > idx && nums[i] == nums[i-1]) continue;
                int tem = target - nums[i];
                if(tem < 0){
                    break;
                }
                list.add(nums[i] );
                backtrack(i+1, tem);
                list.remove(list.size() - 1);
            }

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new Solution().combinationSum2(candidates, target);
        System.out.println("lists = " + lists);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,1,1,1,1,1,1,1,1,1,
                2,2,2,3,3,3,4
        };
        new solu40().combinationSum2(nums, 5);
    }
}

