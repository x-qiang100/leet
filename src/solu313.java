import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/9 上午9:49
 * @ClassName solu313
 * @Description 超级丑数
 */

public class solu313 {

    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int idx;
            int l = primes.length;
            int[] dp = new int[n+1];
            dp[1] = 1;
            int[] travel = new int[l];
            Arrays.fill(travel, 1);
            int[] val = new int[l];
            for (int i = 0; i < l; i++) {
                val[i] = primes[i];
            }
            for (int i = 2; i <= n; i++) {
                int idMin = 0;
                int min = val[0];
                for (int j = 0; j < l; j++) {
                    if(val[j] < min){
                        min = val[j];
                    }
                }
                dp[i] = min;

                for (int j = 0; j < l; j++) {
                    if(val[j] == min){
                        idMin = j;
                        travel[idMin]++;
                        val[idMin] = dp[travel[idMin] ]*primes[idMin];
                    }
                }

            }
            return dp[n];
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int i = new Solution().nthSuperUglyNumber(n, primes);
        System.out.println("i = " + i);
        return i;
    }


    public static void main(String[] args) {
        new solu313().nthSuperUglyNumber(12,new int[]{
           2,7,13,19
        });
    }
}

