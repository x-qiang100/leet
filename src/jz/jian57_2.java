package jz;

import javax.print.DocFlavor;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/29 9:21
 * ClassName:jian57_2
 * Package:jz
 * Description:
 */
public class jian57_2 {
    //可以不用list,用数组即可
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if(target <= 2) return new int[][]{};
            List<List<Integer>> list = new ArrayList<>();
            boolean odd = false;
            if( target%2 == 1){
                List<Integer> ints = new ArrayList<>();
                ints.add(target/2);
                ints.add(target/2+1);
                list.add(ints);
                odd = true;
            }
            //分为奇数和偶数
            for (int i = 3; i < target; i++) {
                int remainder = target%i;
                int mid = target/i;
                //奇数
                if(remainder == 0 && mid-i/2>0 && i%2==1){
                    List<Integer> ints = new ArrayList<Integer>();
                    for (int j = mid-i/2; j <= mid+i/2; j++) {
                        ints.add(j);
                    }
                    list.add(ints);
                }
                if(i%2==0 && target%(i/2) == 0){

                    //29 24
                    int sun = target/(i/2);
                    if( sun%2 == 1 && sun/2-i/2+1>0){
                        List<Integer> ints = new ArrayList<Integer>();
                        for (int j = sun/2-i/2+1 ; j <= sun/2+i/2; j++) {
                            ints.add(j);
                        }
                        list.add(ints);
                    }
                }
            }

            int[][] ans = new int[list.size()][];

            for (int i = 0; i < list.size(); i++) {
                ans[i] = new int[list.get(list.size()-1-i).size()];
                List<Integer> li = list.get(list.size()-1-i);
                for (int j = 0; j < li.size(); j++) {
                    ans[i][j] = li.get(j);
                }
            }
            return ans;
        }
    }


    void test(){
        new Solution().findContinuousSequence(93);
    }

    public static void main(String[] args) {
        new jian57_2().test();
    }
}
