package jz;

/**
 * @author:xq
 * @date:2021/9/26 16:24
 * ClassName:jian15
 * Package:jz
 * Description: 二进制中1的个数
 */
public class jian15 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            final String string = Integer.toBinaryString(n);
            int sum = 0;
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(i) == '1'){
                    sum++;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int n = -9;
        Integer in = -9;
        System.out.println("in.byteValue() = " + Integer.toBinaryString(n) );
        System.out.println("n = " + (n>>1));
    }


}
