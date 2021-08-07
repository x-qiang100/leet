import Common.ListNode;

import java.util.*;

/**
 * @author xq
 * @Date 2021/8/7 上午10:14
 * @ClassName solu207
 * @Description 课程表
 */

public class solu207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] lists = new ArrayList[numCourses] ;

            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            int n = prerequisites.length;
            if(n == 0) return true;
            int[] count = new int[numCourses];

            for (int[] prerequisite : prerequisites) {
                int val1 = prerequisite[0];
                int val2 = prerequisite[1];
                lists[val2].add(val1);

                count[val1]++;
            }
            int f = 0;
            while (f == 0) {
                f = -1;
                for (int i = 0; i < numCourses; i++) {
                    if (count[i] == 0) {
                        for (Integer o : lists[i]) {
                            count[o]--;
                        }
                        f = 0;
                        count[i] = -1;
                    }
                }
            }
            for (int i = 0; i < numCourses; i++) {
                if(count[i] > 0) return false;
            }
            return true;
        }

    }

    //深搜 见210
    class Solution2{}

    //广搜
    class Solution3 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] lists = new ArrayList[numCourses] ;

            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            int n = prerequisites.length;
            if(n == 0) return true;
            int[] count = new int[numCourses];

            for (int i = 0; i < n; i++) {
                int val1 = prerequisites[i][0];
                int val2 = prerequisites[i][1];
                lists[val2].add(val1);

                count[val1]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if(count[i] == 0){
                    queue.offer(i);
                }
            }

            int f = 0;
            while (!queue.isEmpty()){
                f++;
                int u = queue.poll();
                for (Integer integer : lists[u]) {
                    --count[integer];
                    if(count[integer] == 0){
                        queue.offer(integer);
                    }
                }
            }
            return f ==numCourses;
        }

    }

    //奇奇怪怪的邻接表
    class Solution4 {
        int[] e;
        int[] ne;
        int idx;
        int[] h;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //入度值
            int[] d = new int[numCourses];
            e = new int[prerequisites.length];
            ne = new int[prerequisites.length];
            h = new int[numCourses];
            Arrays.fill(h, -1);
            idx = 0;
            for (int[] ints : prerequisites) {
                int b = ints[1];
                int a = ints[0];
                add(a, b);
                d[b]++;
            }

            System.out.println("Arrays.toString(e) = " + Arrays.toString(e));
            System.out.println("Arrays.toString(ne) = " + Arrays.toString(ne));
            System.out.println("Arrays.toString(h) = " + Arrays.toString(h));

            return true;
        }

        void add(int a, int b){
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;
        }

    }





    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean b = new Solution4().canFinish(numCourses, prerequisites);
        System.out.println("b = " + b);
        return b;
    }
    public static void main(String[] args) {
        int[][] n = {
                {1,2},
                {2,3},
                {2,5},
                {2,4},
                {3,4},
                {3,1},
                {5,1},
        };

        new solu207().canFinish(6,n);
    }

}

