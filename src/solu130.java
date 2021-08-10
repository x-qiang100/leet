import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/10 下午8:38
 * @ClassName solu130
 * @Description 被围绕的区域
 */


public class solu130 {

    class Solution {
        final int[][] step = {{-1,0},{1,0},{0,-1},{0,1},};
        int[][] nums;
        int m;
        int n;
        public void solve(char[][] board) {
            m = board.length;
            if(m == 0) return;
            n = board[0].length;
            nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = board[i][j]=='X'?0:1;
                }
            }

            for (int i = 0; i < n; i++) {
                if(nums[0][i] == 1){
                    backtrack(0, i);
                }
                if(nums[m-1][i] == 1){
                    backtrack(m-1, i);
                }
            }

            for (int i = 0; i < m; i++) {
                if(nums[i][0] == 1){
                    backtrack(i, 0);
                }
                if(nums[i][n-1] == 1){
                    backtrack(i, n-1);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(nums[i][j] == 1){
                        board[i][j] = 'X';
                    }
                }
            }

        }
        void backtrack(int row, int col){
            if(row >= m || row < 0 || col >= n || col < 0){
                return;
            }
            //已经遍历过
            if(nums[row][col] == 2 || nums[row][col] == 0){
                return;
            }
            nums[row][col] = 2;
            for (int i = 0; i < 4; i++) {
                    int temR = row+step[i][0] + row;
                    int colR = col+step[i][1] + col;
                    backtrack(row+step[i][0], col+step[i][1]);
            }
        }
    }

    public void solve(char[][] board) {
        new Solution().solve(board);
        System.out.println("Arrays.deepToString(board) = " + Arrays.deepToString(board));
    }

    public static void main(String[] args) {
        int[][] board = {
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {0,1,0,0,0},
        };
        char[][] c = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                c[i][j] = board[i][j] == 0?'X':'O';
            }
        }
        new solu130().solve(c);
    }
}
/*
[       ["X","X","X","X","O","O","X","X","O"],
        ["O","O","O","O","X","X","O","O","X"],
        ["X","O","X","O","O","X","X","O","X"],
        ["O","O","X","X","X","O","O","O","O"],
        ["X","O","O","X","X","X","X","X","O"],
        ["O","O","X","O","X","O","X","O","X"],
        ["O","O","O","X","X","O","X","O","X"],
        ["O","O","O","X","O","O","O","X","O"],
        ["O","X","O","O","O","X","O","X","O"]]

 */

