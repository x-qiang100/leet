package jz;

/**
 * @author:xq
 * @date:2021/9/26 17:05
 * ClassName:jian65
 * Package:jz
 * Description:
 */
public class jian65 {
    class Solution {
        public int add(int a, int b) {
            while (b != 0){
                int tem = a^b;
                b = (a&b)<<1;
                a = tem;
            }
            return a;
        }
    }
}
