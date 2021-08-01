import java.util.ArrayList;
import java.util.List;

public class solu78 {



    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<Integer> list = new ArrayList<>();
            List<List<Integer>> lists = new ArrayList<>();
            dfs(list, lists, nums, 0);
            lists.add(new ArrayList<>());
            return lists;
        }

        void dfs(List<Integer> list, List<List<Integer>> lists, int[] nums, int k){
            int l = nums.length;
            if(k >= l){
                return ;
            }
            for (int i = k; i < l; i++) {
                list.add( nums[i] );
                lists.add(new ArrayList<>(list) );
                dfs(list, lists, nums, i+1 );

//                System.out.println("list = " + list);
                list.remove(list.size() - 1);
            }

            return ;
        }
    }
    //使用迭代和位运算进行
    class Solution2{
        List<Integer> t = new ArrayList<>();
        List<List<Integer >> ans = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1<<n); mask++) {
                t.clear();
                for (int i = 0; i < n; i++) {
                    if((mask & (1 << i)) != 0){
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<>(t));
            }
            return ans;
        }
    }

    //递归实现子集枚举
    class Solution3{
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            ans.add(new ArrayList<>());
            return ans;
        }

        void dfs(int i, int[] nums){
            if( i == nums.length){
                return;
            }
            System.out.println(t+"start");
            t.add(nums[i] );
            ans.add(new ArrayList<>(t) );
            System.out.println(t+"first in");
            dfs(i+1, nums);
            t.remove(t.size() - 1 );
            System.out.println(t+"second in");
            dfs(i+1, nums);
            System.out.println(t+"end");
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> lists = new Solution3().subsets(nums);

        System.out.println(lists);
        return lists;
    }

    public static void main(String[] args) {
        solu78 s = new solu78();
        s.subsets(new int[]{
                1,2,3,4
                }
                );
    }
}
