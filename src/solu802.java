import java.util.*;

/**
 * @author xq
 * @Date 2021/8/5 上午8:34
 * @ClassName solu802
 * @Description 找到最终的安全状态
 */

public class solu802 {
    //time out
    class Solution1 {

        int[][] matrix ;
        int[][] maps;
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            matrix = new int[n][n];
            maps = graph;
            for (int i = 0; i < n; i++) {
                for (int j : graph[i]) {
                    matrix[i][j] = 1;
                }

            }
            dfs(0);
            for (int i = 0; i < n; i++) {
                if( !walked.contains(i)){
                    dfs(i);
                }
            }
            int[] ans = new int[n];
            for (Integer integer : sets) {
                ans[integer] = -1;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(ans[i] == 0){
                    list.add(i);
                }
            }

            //test
//            {
//                System.out.println("walked = " + walked);
//                System.out.println("sets = " + sets);
//            }
            return list;
        }
        Set<Integer> walked = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> sets = new HashSet<>();
        void dfs(int i){
            walked.add(i);
            if(set.contains(i) ){
                sets.addAll(set);
                return;
            }
            set.add(i );
            for (int j : maps[i]) {
                dfs(j);
            }
            set.remove(i);
        }

    }

    /*统计出度为0，并置该节点为null，
     *重复上一步
     */
    class Solution2 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;

            int[] flag = new int[n];
            int s = 1;
            int count  = 1;
            while (  count > 0) {
                count =0;
                for (int i = 0; i < n; i++) {
                    if(flag[i] < s && flag[i]!=0){
                        continue;
                    }
                    int l = graph[i].length;
                    if (l == 0) {
                        flag[i] = s;
                        count = 1;
                    } else {
                        for (int j = 0; j < l; j++) {
                            if (graph[i][j] != -1) {
                                break;
                            }
                            if (j == l - 1) {
                                graph[i] = new int[0];
                                flag[i] = s;
                                count = 1;
                            }
                        }
                    }
                }
                if(count == 0){
                    break;
                }
                for (int[] ints : graph) {
                    int l = ints.length;
                    for (int i = 0; i < l; i++) {
                        if (ints[i]!=-1 && flag[ ints[i] ] == s) {
                            ints[i] = -1;
                        }
                    }
                }
                s++;

            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                if(graph[i].length == 0){
                    list.add(i );
                }
            }
            return list;
        }
    }

    /**
     * 设置反向图
     * 统计出度
     */
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            return null;
        }
    }

    /**
     * 三色标记法+深度优先搜索
     * 三种状态（未被访问0，正在访问吗1，已经安全2）
     * 首次遇到标记1，若再次遇到一，则危险，退出搜索，依次返回，传递所有节点。
     * 走完，则标记2，返回。
     */
    class Solution0 {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            return null;
        }
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new Solution().eventualSafeNodes(graph);
        System.out.println("list = " + list);
        return list;
    }

    public static void main(String[] args) {
        int[][] g = {
/*                {1,2,3,4},
                {1,2},
                {3,4},
                {0,4},
                {},*/
/*
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {},*/
                {},
                {0,2,3,4},
                {3},
                {4},
                {}
        };

//        int[][] s = new int[200][];
        new solu802().eventualSafeNodes(g );
    }
}
