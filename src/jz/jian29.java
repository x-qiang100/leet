package jz;

import java.util.Arrays;

/**
 * @author:xq
 * @date:2021/10/2 10:46
 * ClassName:jian29
 * Package:jz
 * Description:
 */
public class jian29 {

    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if(m == 0 ) return null;
            int n = matrix[0].length;

            int idx = 0;
            int[] ans = new int[m*n];
            for (int i = 0, j = 0; i < (m+1)/2 && j < (n+1)/2 ; i++, j++) {

                for (int k = j; k < n - j; k++) {
                    ans[idx++] = matrix[i][k];
//                    System.out.println("ans[idx]1 = " + ans[idx-1]);
                }
                if(i == m-i-1){
                    break;
                }

                for (int k = i + 1 ; k < m - i; k++) {
                    ans[idx++] = matrix[k][n - j - 1];
//                    System.out.println("ans[idx]2 = " + ans[idx-1]);
                }
                if(j == n-j-1){
                    break;
                }

                for (int k = n-j-2 ; k >= j; k--) {
                    ans[idx++] = matrix[m-i-1][k];
//                    System.out.println("ans[idx]3 = " + ans[idx-1]);
                }
                for (int k = m-i-2 ; k >  i; k--) {
                    ans[idx++] = matrix[k][j];
//                    System.out.println("ans[idx]4 = " + ans[idx-1]);
                }

            }

//            System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
            return ans;
        }
    }

    void test(){
        new Solution().spiralOrder(new int[][]{
//            {1,2,3,4,11,1},
//            {5,6,7,8,12,3},
//            {9,10,11,12,35,7},
//            {9,10,11,12,35,7},
//            {9,10,11,12,35,7},
                {1,2,3},
//            {9,12,11},
//            {9,34,11},
        });
    }

    public static void main(String[] args) {
        int[] l =new int[]{};
        int[] l1 =null;
        int[] l2;

        new jian29().test();
    }
}
