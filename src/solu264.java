import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/9 上午10:20
 * @ClassName solu264
 * @Description 丑数
 */

public class solu264 {
    class Solution {
        public int nthUglyNumber(int n) {
            int primes[] = new int[3];
            primes[0] = 2;
            primes[1] = 3;
            primes[2] = 5;
            int[] dp = new int[n+1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
//            {
//                1,1,1,1
//                2,3,5,2
//                4,3,5,3
//                4,6,5,4,
//                6,6,5,5
//                6,6,10,6
//                8,6,10,8
//                8,9,10,10
//            }
            for (int i = 2; i <= n; i++) {
                int n1 = dp[p2]*2;
                int n3 = dp[p3]*3;
                int n5 = dp[p5]*5;
                int min = Math.min(n1, Math.min(n3,n5));
                dp[i] = min;
                if(n1 == min){
                    p2++;
                }
                if(n3 == min){
                    p3++;
                }
                if(n5 == min){
                    p5++;
                }
            }
            return dp[n];
        }



    }

    public int nthUglyNumber(int n) {
        int i = new Solution().nthUglyNumber(n);
        System.out.println("i = " + i);
        return i;
    }
    public static void main(String[] args) {
        new solu264().nthUglyNumber(12);
    }
}

