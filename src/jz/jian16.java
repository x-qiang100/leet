package jz;

/**
 * @author:xq
 * @date:2021/9/25 21:08
 * ClassName:jian16
 * Package:jz
 * Description:  数值的整数次方
 */
public class jian16 {

    class Solution {
        public double myPow(double x, int n) {
            return myPow(x, n);
        }

        double div(double x, int n){
            if(n == 0) return 1;
            if(n == 1) return x;
            if(n == -1) return 1/x;
            double temp = div(x, n/2);
            if(n%2 == 0){
                return temp*temp;
            }else {
                return temp*temp*x;
            }
        }
    }
}
