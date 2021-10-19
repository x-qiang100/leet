package jz;

import java.awt.event.MouseAdapter;
import java.util.LinkedList;

/**
 * @author:xq
 * @date:2021/10/18 22:35
 * ClassName:jian44
 * Package:jz
 * Description:
 */
public class jian44 {
    class Solution {
        public int findNthDigit(int n){
            if(n < 10) return n;
            long cou = 10;
            int len = 1;
            long count = 1;

            while( true ){
                long temp = cou;
                len++;
                count*=10;
                cou = cou + count*len*9;

                if(cou > Integer.MAX_VALUE) cou = Integer.MAX_VALUE;

                if(n <= cou){
                    int x = (int) ((int) n - temp);
                    int idx = x/len;
                    int mod = x%len;
                    System.out.println("len = " + len);
                    System.out.println("idx = " + idx);
                    int s = (int) Math.pow(10, len-1) + idx;
                    System.out.println("s = " + s);
                    final LinkedList<Integer> integers = new LinkedList<>();
                    while (s > 0){
                        integers.addFirst(s%10);
                        s = s/10;
                    }
                    return integers.get(mod);
                }


            }
        }
    }


    void test(){

        int n = 999;
        for (int i = 1000000000; i < 1000000100; i++) {
            final int nthDigit = new Solution().findNthDigit(i);
            System.out.println("i = " + i);
            System.out.println("nthDigit = " + nthDigit);
        }

    }
    public static void main(String[] args) {
        new jian44().test();
    }
}
