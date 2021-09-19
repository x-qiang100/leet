package jz;

/**
 * @author:xq
 * @date:2021/9/19 15:10
 * ClassName:jian13
 * Package:jz
 * Description: 机器人的运动范围
 */
public class jian13 {
    class Solution {
        public int movingCount(int m, int n, int k) {
            if(k == 0) return 1;
            int count = 1;
            boolean[][] vis = new boolean[m][n];
            vis[0][0] = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == 0 && j == 0){
                        continue;
                    }
                    if(!sum(i,j,k)) continue;
                    if(i-1 >= 0){
                        vis[i][j] |= vis[i-1][j];
                    }
                    if(j - 1 >= 0){
                        vis[i][j] |= vis[i][j-1];
                    }
                    if(vis[i][j]) count++;
                }
            }
            return count;
        }

        boolean sum(int s1, int s2, int k){
            if(s1 <0 || s2 < 0){
                return false;
            }
            int sum = 0;
            while (s1>0){ sum+=s1%10;             s1 = s1/10; }
            while (s2>0){ sum+=s2%10;             s2 = s2/10; }
            return sum <= k;
        }
    }
}
