import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xq
 * @Date 2021/8/10 下午4:42
 * @ClassName solu51
 * @Description N皇后问题
 */

public class solu51 {
    class Solution {
        int[][] nums;
        boolean[] row;
        boolean[] column;
        boolean[] rightL;
        boolean[] leftR;
        int n;
        int[] location ;
        List<List<String>> lists;

        public List<List<String>> solveNQueens(int n) {
            nums = new int[n][n];
            row = new boolean[n];
            column = new boolean[n];
            rightL = new boolean[2 * n - 1];
            leftR  = new boolean[2 * n - 1];
            lists = new ArrayList<>();
            location = new int[n];
            this.n = n;
            backtrack(0);
            return lists;
        }

        void backtrack( int co){
            if( co == n){
                List<String> str = queens(location);
                lists.add(str );
                return;
            }
            for (int i = 0; i < n; i++) {
                if(!row[i] && !rightL[i + co] && !leftR[i - co + n - 1]){

                    row[i] = true;
                    rightL[ i+co ] = true;
                    leftR[i - co + n - 1] = true;
                    //co:column i:row
                    location[co] = i;
                    backtrack( co + 1);
                    location[co] = -1;
                    row[i] = false;
                    rightL[ i+co ] = false;
                    leftR[i - co + n - 1] = false;
                }
            }

        }

        private List<String> queens(int[] location){
            int n = location.length;
            List<String> list = new ArrayList<>();

            for (int value : location) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (value == j) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                list.add(s.toString());
            }

            return list;
        }

    }


    public List<List<String>> solveNQueens(int n) {

//        for (int i = 1; i <= 5; i++) {
//            System.out.println("i = " + i);
            List<List<String>> lists = new Solution().solveNQueens(5);
            System.out.println("lists = " + lists);
//        }


        return null;
    }

    public static void main(String[] args) {
        new solu51().solveNQueens(8);
    }


}

