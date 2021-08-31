/**
 * @author xq
 * @Date 2021/8/13 上午8:51
 * @ClassName solu233
 * @Description 数字1的个数
 */

public class solu233 {
    class Solution {
        public int countDigitOne(int n) {
            // mulk 表示 10^k
            // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
            // 但为了让代码看起来更加直观，这里保留了 k
            long mulk = 1;
            int ans = 0;
            for (int k = 0; n >= mulk; ++k) {
                ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
                mulk *= 10;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }

}

