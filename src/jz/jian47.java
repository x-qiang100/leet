package jz;

import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/9/14 下午5:10
 * @ClassName jian47
 * @Description 礼物的最大价值
 */

public class jian47 {
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] maxAns = new int[m][n];
            maxAns[0][0] = grid[0][0];

            for (int i = 1; i < m; i++) {
                maxAns[i][0] = grid[i][0] + maxAns[i-1][0];
            }
            for (int i = 1; i < n; i++) {
                maxAns[0][i] = grid[0][i] + maxAns[0][i-1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    maxAns[i][j] = Math.max(maxAns[i][j-1], maxAns[i-1][j])+grid[i][j];
                }
            }
            System.out.println("Arrays.deepToString(maxAns) = " + Arrays.deepToString(maxAns));
//            maxAns[i][j] = Math.max(maxAns[i][j-1]+grid[i][j],);
            return maxAns[m-1][n-1];
        }
    }

    void test(){
        int[][] grid = {
                {1,3,1,3},
                {1,5,1,8},
                {4,2,1,9},
        };
        System.out.println("new Solution().maxValue(grid) = " + new Solution().maxValue(grid));
    }
    public static void main(String[] args) {
        new jian47().test();
    }
}

