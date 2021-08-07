import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/7 上午9:52
 * @ClassName solu73
 * @Description 矩阵置零
 */

public class solu73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean a = false;
            boolean b = false;
            for (int i = 0; i < m; i++) {
                if(matrix[i][0] == 0){
                    a = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    b = true;
                    break;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                            matrix[i][j] = 0;
                    }
                }
            }
            if(a ){
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if(b){
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }

        }
    }

    public void setZeroes(int[][] matrix) {
        new Solution().setZeroes(matrix);
        System.out.println("Arrays.toString(matrix) = " + Arrays.deepToString(matrix));
    }
    public static void main(String[] args) {
        int[][] m = {
                {3,1,2,0},
                {1,0,1,2},
                {1,1,1,2},
        };
        new solu73().setZeroes(m);
    }
}

