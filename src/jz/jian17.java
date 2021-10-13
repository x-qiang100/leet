package jz;

/**
 * @author:xq
 * @date:2021/10/11 16:34
 * ClassName:jian17
 * Package:jz
 * Description:
 */
public class jian17 {

    class Solution {
        public int[] printNumbers(int n) {
            int l = (int) Math.pow(10, n) - 1;
            int[] ans = new int[l];
            for (int i = 1; i <= l; i++) {
                ans[i-1] = i;
            }
            return ans;
        }
    }
    void test(){ }
    public static void main(String[] args) { }

}
