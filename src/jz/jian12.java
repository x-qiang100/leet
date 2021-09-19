package jz;

/**
 * @author:xq
 * @date:2021/9/19 14:28
 * ClassName:jian12
 * Package:jz
 * Description: 矩阵中的路径
 */
public class jian12 {
    class Solution {
        char[][] map;
        String str;
        int[][] ints;

        public boolean exist(char[][] board, String word) {
            map = board;
            str = word;
            ints = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int i1 = 0; i1 < board[0].length; i1++) {
                     boolean dfs = dfs(i, i1, 0);
                    if(dfs) return true;
                }
            }
            return false;
        }

        boolean dfs(int i, int j, int idx) {
            if (idx == str.length()) {
                return true;
            }
            if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
                return false;
            }
            if (ints[i][j] == 1) {
                return false;
            }
            if (map[i][j] != str.charAt(idx)) {
                return false;
            }
            ints[i][j] = 1;
            boolean b1 = dfs(i + 1, j, idx + 1);
            if(b1) return true;
            boolean b2 = dfs(i - 1, j, idx + 1);
            if(b2) return true;
            boolean b3 = dfs(i, j + 1, idx + 1);
            if(b3) return true;
            boolean b4 = dfs(i, j - 1, idx + 1);
            if(b4) return true;
            ints[i][j] = 0;

            return false;
        }
    }
        void test(){
            char[][] c =  {
                    {'a', 'b', 'c', 'e'},
                    {'b', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'},
            };
            String  s = "bccedfb";
            System.out.println("new Solution().exist() = " + new Solution().exist(c, s));
        }

    public static void main(String[] args) {
        new jian12().test();
    }

}
