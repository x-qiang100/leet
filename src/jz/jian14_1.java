package jz;

/**
 * @author:xq
 * @date:2021/9/29 8:58
 * ClassName:jian14_1
 * Package:jz
 * Description:
 */
public class jian14_1 {
    class Solution {

        public int cuttingRope(int n) {
            if(n == 2) return 1;
            int x = n/3;
            int yu = n%3;
            int ans = 1;
            if(yu == 1){
                ans = (int) Math.pow(3,x-1)*4;
            }else if(yu == 2){
                ans = (int) Math.pow(3,x)*yu;
            }else {
                ans = (int) Math.pow(3,x);
            }
            return ans;
        }
    }
}
