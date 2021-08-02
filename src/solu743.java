import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/2 下午3:39
 * @ClassName solu763
 * @Description leetcode 743
 */

public class solu743 {
    class Solution {
//        int[][] ints = new int[1][1];
        public int networkDelayTime(int[][] times, int n, int k) {
            int[] s = new int[3];
            int[][] ints = new int[n+1][n+1];
            int INF = 0x3f3f3f3f;
            //更新含权值的邻接矩阵
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ints[i][j] = ints[j][i] = (i == j)?0:INF;
                }
            }
            for (int[] time : times) {
                ints[time[0]][time[1]] = time[2];
            }

            //Dijkstra
            boolean[] vis = new boolean[n + 1];
            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[k] = 0;
            //遍历n次
            for (int p = 1; p <= n; p++) {
                int f = -1;
                //选择未添加集离集合最近的节点
                for (int i = 1; i <= n; i++) {
                    if(!vis[i] && (f == -1 || dist[i]<dist[f])) f = i;
                }
                //在集合中添加已选中的节点
                vis[f] = true;
                //更新节点到已选中集的最小值
                for (int i = 1; i <= n; i++) {
                    dist[i] = Math.min(dist[i], dist[f]+ints[f][i]);
                }
            }
            int ans = 0;
            for (int i = 1; i < n+1; i++) {
                ans = Math.max(ans, dist[i]);
            }
            System.out.println("dist = " + Arrays.toString(dist));
            return ans>=INF/2 ? -1 : ans ;
        }


    }

    public int networkDelayTime(int[][] times, int n, int k) {

        int i = new Solution().networkDelayTime(times, n, k);
        System.out.println("i = " + i);
        return i;
    }

    public static void main(String[] args) {
        solu743 s = new solu743();
        int[][] ints = {
                {2,1,1},
                {2,3,3},
                {3,4,1},
        };
        s.networkDelayTime(ints, 4, 2);

    }

}

