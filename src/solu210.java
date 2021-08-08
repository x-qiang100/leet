import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xq
 * @Date 2021/8/8 下午7:24
 * @ClassName solu210
 * @Description 课程表2
 */

public class solu210 {

    //
    class Solution {
        List<List<Integer>> matrix ;
        //搜索状态，0未搜索，1正在搜索，2，已完成
        int[] visited;
        boolean valid = false;

        int[] result;
        int index;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            matrix = new ArrayList<>();
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses-1;


            for (int i = 0; i < numCourses; i++) {
                matrix.add(new ArrayList<>());
            }
            for (int[] ints : prerequisites) {
                matrix.get(ints[1]).add(ints[0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if(visited[i] == 0){
                    dfs(i);
                }
                if(valid){
                    return new int[0];
                }
            }
            return result;
        }

        void dfs(int u){
            visited[u] = 1;
            for (Integer v : matrix.get(u)) {
                if(visited[v] == 0){
                    dfs(v);
                    if(valid){
                        return;
                    }
                }else if(visited[v] == 1){
                    valid = true;
                    return;
                }
            }
            visited[u] = 2;
            result[index--] = u;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] order = new Solution().findOrder(numCourses, prerequisites);
        System.out.println("Arrays.toString(order) = " + Arrays.toString(order));
        return order;
    }

    public static void main(String[] args) {

        new solu210().findOrder(2,new int[][]{
                {1, 0},
        });
    }

}

