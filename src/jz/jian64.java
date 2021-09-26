package jz;

/**
 * @author:xq
 * @date:2021/9/24 13:35
 * ClassName:jian64
 * Package:jz
 * Description:
 */
public class jian64 {
}
class Solution {
    int ans = 0;
    public int sumNums(int n) {
         def(n);
         return ans;
    }

    boolean def(int n){
        return  (n==0) || (def(n-1) & (ans=n+ans)>0) ;
    }
}